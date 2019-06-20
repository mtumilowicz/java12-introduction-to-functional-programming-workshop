[![Build Status](https://travis-ci.com/mtumilowicz/java12-introduction-to-functional-programming-workshop.svg?branch=master)](https://travis-ci.com/mtumilowicz/java12-introduction-to-functional-programming-workshop)
# java12-introduction-to-functional-programming-workshop

# project description
* the main goal of this workshops are to introduce basic functional programming concepts like
`flatMap`, `reduce` and show how they was formally invented
* https://www.youtube.com/watch?v=9RGVDdE5QjI
* https://github.com/shishkin/java-fp
* https://github.com/mtumilowicz/java11-stream-map-filter-implementation-using-flatMap
* https://github.com/mtumilowicz/java12-stream-flatMap-implementation-using-reduce
* https://github.com/mtumilowicz/java11-stream-map-filter-implementation-using-reduce
* workshops are in `workshop` package
    * `Step1_LoopTest` - loop that we will refactor in 6 steps
    * `Step2_Split_Workshop` - split loop into many tiny functions
    * `Step3_Recursion_Workshop` - introduce recursion
        * `Step3P_Recursion_Workshop` - use vavr API
    * `Step4_FlatMap_Workshop` - abstract into `flatMap`
    * `Step5_Reduce_Workshop` - abstract `flatMap` into `reduce`
    * `Step6_Filter_Map_Workshop` - implement `filter` and `map` using `flatMap`
    * `Step7_Streams_Answer` - implement using java's Stream API
* answers with correctly implemented workshop methods are in 
`answers` package

# workshops
1. the main goal is to refactor following loop:
    ```
    static int sumOfSquaresOfPositiveEvenNumbersUpTo(int max) {
        int sum = 0; // SUM (expression)
    
        for (int x = 1; x <= max; x++) { // ITERATE (statement, mutation)
            if (x % 2 == 0) { // FILTER (statement)
                sum += x * x; // SQUARE and SUM (statement, expression, mutation)
            }
        }
    
        return sum;
    }
    ```
    into something like this:
    ```
    sum(square(filterEven(iteratePositivesUpTo(max)))) // only expressions
    ```
    and then, of course - using java Stream API
    ```
    IntStream
        .rangeClosed(1, max)
        .filter(isEven)
        .map(square)
        .sum();
    ```
    problems with the very first peace of code:
    * important parts of your code have to stick out
    * not testable in isolation
    * reusability is quite low
    * by introducing mutable state in statement based programming
        we sacrifice the opportunity to encapsulate code (to refactor
        it with ease)
        * statements - complete line of code that performs some action
        * expressions - any section of the code that evaluates to a value
        * rule of thumb: if you can print it, or assign it to a variable, it's an expression; if you can't, 
        it's a statement
        
1. we will try to get rid of:
    * violation of SRP (single responsibility principle)
    * mutable variables
    * statement-based programming
    
    using:
    * pure functions
        * not change anything (no side-effects)
        * not depends on something that can possibly change (same input = same output)
        * note that pure functions are directly connected to referential transparency - substitute 
        code with values (in your mind you can replace code with values - you don't
        need to track of state mutations etc.)
        * note that pure functions does not need to be mocked
    * recursion (to beat mutations)
        * theoretical foundation of referential transparency
        * `StackOverflow`
        * tail-recursion
        * trampoline
1. if we rewrite smaller functions using recursion, it is easy to see that some pattern emerges:
    ```
    static List<Integer> filterEven(List<Integer> xs) {
        if (xs.isEmpty()) return List.empty();
        else return xs.head() % 2 == 0
                ? filterEven(xs.tail()).prepend(xs.head())
                : filterEven(xs.tail());
    }
    
    static List<Integer> square(List<Integer> xs) {
        if (xs.isEmpty()) return List.empty();
        else return square(xs.tail()).prepend(xs.head() * xs.head());
    }
    ```
    it's recursion + concatenation and could be easily abstracted into well-know `flatMap`:
    ```
    static List<Integer> flatMap(List<Integer> xs, Function<Integer, List<Integer>> f) {
        if (xs.isEmpty()) return List.empty();
        else return f.apply(xs.head()).appendAll(flatMap(xs.tail(), f));
    }
    ```
1. if we take `sum` function, emerging pattern is well-know `reduce`:
    ```
    static int sum(List<Integer> xs) {
        if (xs.isEmpty()) return 0;
        else return xs.head() + sum(xs.tail());
    }
    ```
    recursion, transforming + combining:
    ```
    static <A, R> R reduce(List<A> xs, R zero, BiFunction<R, A, R> combine) {
        if (xs.isEmpty()) return zero;
        else return combine.apply(reduce(xs.tail(), zero, combine), xs.head());
    }
    ```
1. note that `flatMap` is special case of `reduce`:
    ```
    static <A> List<A> flatMap(List<A> xs, Function<A, List<A>> f) {
        return reduce(xs, List.empty(), (acc, x) -> f.apply(x).appendAll(acc));
    }
    ```
1. note that `map`, `filter` could be implemented using only `flatMap`
    * https://github.com/mtumilowicz/java11-stream-map-filter-implementation-using-flatMap
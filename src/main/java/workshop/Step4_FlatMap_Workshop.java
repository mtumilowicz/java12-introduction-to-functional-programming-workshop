package workshop;

import io.vavr.collection.List;

import java.util.function.Function;

public class Step4_FlatMap_Workshop {

    static List<Integer> flatMap(List<Integer> xs, Function<Integer, List<Integer>> f) {
        // xs.isEmpty
        // f, xs.head(), appendAll, flatMap, xs.tail()
        
        return null;
    }

    static List<Integer> filterEven(List<Integer> xs) {
        // flatMap, x -> x % 2
        return null;
    }

    static List<Integer> square(List<Integer> xs) {
        // flatMap
        return null;
    }

    static int sum(List<Integer> xs) {
        if (xs.isEmpty()) return 0;
        else return xs.head() + sum(xs.tail());
    }

    static List<Integer> iteratePositivesUpTo(int max) {
        if (max <= 0) return List.empty();
        else return iteratePositivesUpTo(max - 1).append(max);
    }

    static int sumOfSquaresOfPositiveEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iteratePositivesUpTo(max))));
    }
}

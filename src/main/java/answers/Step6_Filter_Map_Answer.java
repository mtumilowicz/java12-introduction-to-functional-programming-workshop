package answers;

import io.vavr.collection.List;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Step6_Filter_Map_Answer {

    static <A, R> R reduce(List<A> xs, R zero, BiFunction<R, A, R> combine) {
        if (xs.isEmpty()) return zero;
        else return combine.apply(reduce(xs.tail(), zero, combine), xs.head());
    }

    static <A, B> List<B> flatMap(List<A> xs, Function<A, List<B>> f) {
        return reduce(xs, List.empty(), (acc, x) -> f.apply(x).appendAll(acc));
    }

    static <A> List<A> filter(List<A> xs, Predicate<A> f) {
        return flatMap(xs, x -> f.test(x) ? List.of(x) : List.empty());
    }

    static <A, B> List<B> map(List<A> xs, Function<A, B> f) {
        return flatMap(xs, x -> List.of(f.apply(x)));
    }

    static List<Integer> iteratePositivesUpTo(int max) {
        if (max <= 0) return List.empty();
        else return iteratePositivesUpTo(max - 1).append(max);
    }

    static List<Integer> filterEven(List<Integer> xs) {
        return filter(xs, x -> x % 2 == 0);
    }

    static List<Integer> square(List<Integer> xs) {
        return map(xs, x -> x * x);
    }

    static Integer sum(List<Integer> xs) {
        return reduce(xs, 0, Integer::sum);
    }

    static int sumOfSquaresOfPositiveEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iteratePositivesUpTo(max))));
    }
}

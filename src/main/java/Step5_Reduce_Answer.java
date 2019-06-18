import io.vavr.collection.List;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Step5_Reduce_Answer {

    static <A, R> R reduce(List<A> xs, R zero, BiFunction<R, A, R> combine) {
        if (xs.isEmpty()) return zero;
        else return combine.apply(reduce(xs.tail(), zero, combine), xs.head());
    }

    static <A> List<A> flatMap(List<A> xs, Function<A, List<A>> f) {
        return reduce(xs, List.empty(), (acc, x) -> f.apply(x).appendAll(acc));
    }

    static List<Integer> iterate(int max) {
        if (max == 0) return List.empty();
        else return iterate(max - 1).append(max);
    }

    static List<Integer> filterEven(List<Integer> xs) {
        return flatMap(xs, x -> x % 2 == 0 ? List.of(x) : List.empty());
    }

    static List<Integer> square(List<Integer> xs) {
        return flatMap(xs, x -> List.of(x * x));
    }

    static int sum(List<Integer> xs) {
        return reduce(xs, 0, Integer::sum);
    }

    static int sumOfSquaresOfEvenPositiveNumbersUpTo(int max) {
        return sum(square(filterEven(iterate(max))));
    }
}

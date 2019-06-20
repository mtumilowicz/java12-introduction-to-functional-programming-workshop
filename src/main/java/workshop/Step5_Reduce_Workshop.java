package workshop;

import io.vavr.collection.List;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Step5_Reduce_Workshop {

    static <A, R> R reduce(List<A> xs, R zero, BiFunction<R, A, R> combine) {
        // xs.isEmpty()
        // combine, reduce, xs.tail(), xs.head()
        
        return null;
    }

    static <A> List<A> flatMap(List<A> xs, Function<A, List<A>> f) {
        // reduce, f, appendAll
        
        return null;
    }

    static List<Integer> iteratePositivesUpTo(int max) {
        if (max <= 0) return List.empty();
        else return iteratePositivesUpTo(max - 1).append(max);
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

    static int sumOfSquaresOfPositiveEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iteratePositivesUpTo(max))));
    }
}

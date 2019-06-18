import io.vavr.collection.List;

import java.util.function.Function;

public class D_HigherOrder_Answer {

    static List<Integer> flatMap(List<Integer> xs, Function<Integer, List<Integer>> f) {
        if (xs.isEmpty()) return List.of();
        else return f.apply(xs.head()).appendAll(flatMap(xs.tail(), f));
    }

    static List<Integer> iterate(int max) {
        if (max == 0) return List.of();
        else return iterate(max - 1).append(max);
    }

    static List<Integer> filterEven(List<Integer> xs) {
        return flatMap(xs, x -> x % 2 == 0 ? List.of(x) : List.of());
    }

    static List<Integer> square(List<Integer> xs) {
        return flatMap(xs, x -> List.of(x * x));
    }

    static int sum(List<Integer> xs) {
        if (xs.isEmpty()) return 0;
        else return xs.head() + sum(xs.tail());
    }

    static int sumOfSquaresOfEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iterate(max))));
    }
}

import io.vavr.collection.List;

import java.util.function.Function;

public class Step4_HigherOrder_Answer {

    static List<Integer> flatMap(List<Integer> xs, Function<Integer, List<Integer>> f) {
        if (xs.isEmpty()) return List.empty();
        else return f.apply(xs.head()).appendAll(flatMap(xs.tail(), f));
    }

    static List<Integer> iteratePositiveUpTo(int max) {
        if (max == 0) return List.empty();
        else return iteratePositiveUpTo(max - 1).append(max);
    }

    static List<Integer> filterEven(List<Integer> xs) {
        return flatMap(xs, x -> x % 2 == 0 ? List.of(x) : List.empty());
    }

    static List<Integer> square(List<Integer> xs) {
        return flatMap(xs, x -> List.of(x * x));
    }

    static int sum(List<Integer> xs) {
        if (xs.isEmpty()) return 0;
        else return xs.head() + sum(xs.tail());
    }

    static int sumOfSquaresOfEvenPositiveNumbersUpTo(int max) {
        return sum(square(filterEven(iteratePositiveUpTo(max))));
    }
}

import java.util.List;
import java.util.function.Function;

public class D_HigherOrder_Answer {

    static List<Integer> flatMap(List<Integer> xs, Function<Integer, List<Integer>> f) {
        if (xs.isEmpty()) return List.of();
        else return Lists.concat(f.apply(Lists.head(xs)), flatMap(Lists.tail(xs), f));
    }

    static List<Integer> iterate(int max) {
        if (max == 0) return List.of();
        else return Lists.append(iterate(max - 1), max);
    }

    static List<Integer> filterEven(List<Integer> xs) {
        return flatMap(xs, x -> x % 2 == 0 ? List.of(x) : List.of());
    }

    static List<Integer> square(List<Integer> xs) {
        return flatMap(xs, x -> List.of(x * x));
    }

    static int sum(List<Integer> xs) {
        if (xs.isEmpty()) return 0;
        else return Lists.head(xs) + sum(Lists.tail(xs));
    }

    static int sumOfSquaresOfEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iterate(max))));
    }
}

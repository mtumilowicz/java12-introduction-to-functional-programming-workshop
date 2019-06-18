import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class E_Reduce_Answer {

    static <A, R> R reduce(List<A> xs, R zero, BiFunction<R, A, R> combine) {
        if (xs.isEmpty()) return zero;
        else return combine.apply(reduce(Lists.tail(xs), zero, combine), Lists.head(xs));
    }

    static <A> List<A> flatMap(List<A> xs, Function<A, List<A>> f) {
        return reduce(xs, List.of(), (acc, x) -> Lists.concat(f.apply(x), acc));
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
        return reduce(xs, 0, Integer::sum);
    }

    static int sumOfSquaresOfEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iterate(max))));
    }
}

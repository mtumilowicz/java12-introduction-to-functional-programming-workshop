import org.junit.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static Lists.*;

public class E_Fold {

    public static
    <A, R> R fold(
        List<A> xs,
        R zero,
        BiFunction<R, A, R> combine) {

        if (xs.isEmpty()) return zero;
        else return combine.apply(
            fold(tail(xs), zero, combine),
            head(xs));
    }

    public static
    <A> List<A> flatMap(
        List<A> xs,
        Function<A, List<A>> f) {

        return fold(xs, List.of(),
            (acc, x) -> concat(f.apply(x), acc));
    }

    public static
    List<Integer> iterate(int max) {
        if (max == 0) return List.of();
        else return append(iterate(max - 1), max);
    }

    public static
    List<Integer> filterEven(List<Integer> xs) {
        return flatMap(xs,
            x -> x % 2 == 0 ? List.of(x) : List.of());
    }

    public static
    List<Integer> square(List<Integer> xs) {
        return flatMap(xs, x -> List.of(x * x));
    }

    public static
    int sum(List<Integer> xs) {
        return fold(xs, 0, (r, x) -> r + x);
    }

    public static
    int sumOfSquaresOfEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iterate(max))));
    }

    @Test
    public void test() {
        assertEquals(220, sumOfSquaresOfEvenNumbersUpTo(10));
    }
}

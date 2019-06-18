import org.junit.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static Lists.*;

public class F_Combinators {

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
    <A, B> List<B> flatMap(
        List<A> xs,
        Function<A, List<B>> f) {

        return fold(xs, List.of(),
            (acc, x) -> concat(f.apply(x), acc));
    }

    public static
    <A> List<A> filter(List<A> xs, Predicate<A> f) {
        return flatMap(xs,
            x -> f.test(x) ? List.of(x) : List.of());
    }

    public static
    <A, B> List<B> map(List<A> xs, Function<A, B> f) {
        return flatMap(xs, x -> List.of(f.apply(x)));
    }

    public static
    List<Integer> iterate(int max) {
        if (max == 0) return List.of();
        else return append(iterate(max - 1), max);
    }

    public static
    List<Integer> filterEven(List<Integer> xs) {
        return filter(xs, x -> x % 2 == 0);
    }

    public static
    List<Integer> square(List<Integer> xs) {
        return map(xs, x -> x * x);
    }

    public static Integer sum(List<Integer> xs) {
        return fold(xs, 0, (r, x) -> r + x);
    }

    public static int sumOfSquaresOfEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iterate(max))));
    }

    @Test
    public void test() {
        assertEquals(220, sumOfSquaresOfEvenNumbersUpTo(10));
    }
}

import org.junit.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static Lists.*;

public class D_HigherOrder {

    public static
    List<Integer> flatMap(
        List<Integer> xs,
        Function<Integer, List<Integer>> f) {

        if (xs.isEmpty()) return List.of();
        else return concat(f.apply(head(xs)),
            flatMap(tail(xs), f));
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
        if (xs.isEmpty()) return 0;
        else return head(xs) + sum(tail(xs));
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

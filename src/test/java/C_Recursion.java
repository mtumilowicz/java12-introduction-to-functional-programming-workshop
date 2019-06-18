import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static Lists.*;

public class C_Recursion {

    public static
    List<Integer> iterate(int max) {
        if (max == 0) return List.of();
        else return append(iterate(max - 1), max);
    }

    public static
    List<Integer> filterEven(List<Integer> xs) {
        if (xs.isEmpty()) return List.of();
        else return head(xs) % 2 == 0 ?
            prepend(head(xs), filterEven(tail(xs))) :
            filterEven(tail(xs));
    }

    public static
    List<Integer> square(List<Integer> xs) {
        if (xs.isEmpty()) return List.of();
        else return prepend(head(xs) * head(xs),
            square(tail(xs)));
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

    @Test
    public void testIterate() {
        assertEquals(List.of(1, 2, 3), iterate(3));
    }

    @Test
    public void testSum() {
        assertEquals(6, sum(List.of(1, 2, 3)));
    }

    @Test
    public void testFilterEvent() {
        assertEquals(List.of(2, 4), filterEven(List.of(1, 2, 3, 4)));
    }

    @Test
    public void testSquare() {
        assertEquals(List.of(1, 4, 9, 16), square(List.of(1, 2, 3, 4)));
    }
}

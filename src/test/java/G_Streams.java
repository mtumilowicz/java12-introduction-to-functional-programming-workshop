import org.junit.Test;

import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class G_Streams {

    public static
    int sumOfSquaresOfEvenNumbersUpTo(int max) {

        IntPredicate isEven = x -> x % 2 == 0;

        IntUnaryOperator square = x -> x * x;

        return IntStream
            .rangeClosed(1, max)
            .filter(isEven)
            .map(square)
            .sum();
    }

    @Test
    public void test() {
        assertEquals(220, sumOfSquaresOfEvenNumbersUpTo(10));
    }
}

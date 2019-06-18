import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class G_Streams_Answer {

    static int sumOfSquaresOfEvenNumbersUpTo(int max) {

        IntPredicate isEven = x -> x % 2 == 0;

        IntUnaryOperator square = x -> x * x;

        return IntStream
                .rangeClosed(1, max)
                .filter(isEven)
                .map(square)
                .sum();
    }
}

package workshop;

import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

public class Step7_Streams_Workshop {

    static int sumOfSquaresOfPositiveEvenNumbersUpTo(int max) {

        IntPredicate isEven = x -> x % 2 == 0;

        IntUnaryOperator square = x -> x * x;
        
        // IntStream
        return -1;
    }
}

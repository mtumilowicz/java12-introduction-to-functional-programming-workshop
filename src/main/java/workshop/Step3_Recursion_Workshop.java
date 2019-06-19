package workshop;

import io.vavr.collection.List;

public class Step3_Recursion_Workshop {

    static List<Integer> iteratePositivesUpTo(int max) {
        // max <= 0
        // max - 1, append
        
        return null;
    }

    static List<Integer> filterEven(List<Integer> xs) {
        // xs.isEmpty
        // xs.head() % 2 == 0
        // xs.tail(), prepend
        
        return null;
    }

    static List<Integer> square(List<Integer> xs) {
        // xs.isEmpty()
        // xs.tail, prepend
        
        return null;
    }

    static int sum(List<Integer> xs) {
        // xs.isEmpty
        // xs.head(), xs.tail()
        
        return -1;
    }

    static int sumOfSquaresOfPositiveEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iteratePositivesUpTo(max))));
    }
}

import java.util.ArrayList;
import java.util.List;

public class Step2_Split_Answer {

     static List<Integer> iterate(int max) {
        var result = new ArrayList<Integer>();

        for (int x = 1; x <= max; x++) {
            result.add(x);
        }

        return result;
    }

     static List<Integer> filterEven(List<Integer> xs) {
        var result = new ArrayList<Integer>();

        for (Integer x : xs) {
            if (x % 2 == 0) {
                result.add(x);
            }
        }

        return result;
    }

     static List<Integer> square(List<Integer> xs) {
        var result = new ArrayList<Integer>();

        for (Integer x : xs) {
            result.add(x * x);
        }

        return result;
    }

     static int sum(List<Integer> xs) {
        var result = 0;

        for (Integer x : xs) {
            result += x;
        }

        return result;
    }

    static int sumOfSquaresOfEvenPositiveNumbersUpTo(int max) {
        return sum(square(filterEven(iterate(max))));
    }
}

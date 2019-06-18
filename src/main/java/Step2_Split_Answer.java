import io.vavr.collection.List;

public class Step2_Split_Answer {

    static List<Integer> iteratePositiveUpTo(int max) {
        return List.rangeClosed(1, max);
    }

    static List<Integer> filterEven(List<Integer> xs) {
        return xs.filter(x -> x % 2 == 0);
    }

    static List<Integer> square(List<Integer> xs) {
        return xs.map(x -> x * x);
    }

    static int sum(List<Integer> xs) {
        return xs.sum().intValue();
    }

    static int sumOfSquaresOfPositiveEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iteratePositiveUpTo(max))));
    }
}

import io.vavr.collection.List;

public class Step3P_Recursion_Answer {

    static List<Integer> iteratePositiveUpTo(int max) {
        return max <= 0
                ? List.empty()
                : iteratePositiveUpTo(max - 1).append(max);
    }

    static List<Integer> filterEven(List<Integer> xs) {
        if (xs.isEmpty()) return List.empty();
        else return xs.head() % 2 == 0
                ? filterEven(xs.tail()).prepend(xs.head())
                : filterEven(xs.tail());
    }

    static List<Integer> square(List<Integer> xs) {
        return xs.headOption()
                .map(head -> square(xs.tail()).prepend(head * head))
                .getOrElse(List.empty());
    }

    static int sum(List<Integer> xs) {
       return xs.headOption()
               .map(head -> head + sum(xs.tail()))
               .getOrElse(0);
    }

    static int sumOfSquaresOfPositiveEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iteratePositiveUpTo(max))));
    }
}

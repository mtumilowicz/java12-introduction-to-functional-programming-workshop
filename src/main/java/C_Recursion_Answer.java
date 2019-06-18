import java.util.List;

public class C_Recursion_Answer {

    static List<Integer> iterate(int max) {
        if (max == 0) return List.of();
        else return Lists.append(iterate(max - 1), max);
    }

    static List<Integer> filterEven(List<Integer> xs) {
        if (xs.isEmpty()) return List.of();
        else return Lists.head(xs) % 2 == 0 ?
                Lists.prepend(Lists.head(xs), filterEven(Lists.tail(xs))) :
                filterEven(Lists.tail(xs));
    }

    static List<Integer> square(List<Integer> xs) {
        if (xs.isEmpty()) return List.of();
        else return Lists.prepend(Lists.head(xs) * Lists.head(xs),
                square(Lists.tail(xs)));
    }

    static int sum(List<Integer> xs) {
        if (xs.isEmpty()) return 0;
        else return Lists.head(xs) + sum(Lists.tail(xs));
    }

    static int sumOfSquaresOfEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iterate(max))));
    }
}

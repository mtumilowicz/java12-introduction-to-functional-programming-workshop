import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class F_Combinators_Answer {

    static <A, R> R reduce(List<A> xs, R zero, BiFunction<R, A, R> combine) {
        if (xs.isEmpty()) return zero;
        else return combine.apply(reduce(Lists.tail(xs), zero, combine), Lists.head(xs));
    }

    static <A, B> List<B> flatMap(List<A> xs, Function<A, List<B>> f) {

        return reduce(xs, List.of(), (acc, x) -> Lists.concat(f.apply(x), acc));
    }

    static <A> List<A> filter(List<A> xs, Predicate<A> f) {
        return flatMap(xs, x -> f.test(x) ? List.of(x) : List.of());
    }

    static <A, B> List<B> map(List<A> xs, Function<A, B> f) {
        return flatMap(xs, x -> List.of(f.apply(x)));
    }

    static List<Integer> iterate(int max) {
        if (max == 0) return List.of();
        else return Lists.append(iterate(max - 1), max);
    }

    static List<Integer> filterEven(List<Integer> xs) {
        return filter(xs, x -> x % 2 == 0);
    }

    static List<Integer> square(List<Integer> xs) {
        return map(xs, x -> x * x);
    }

    static Integer sum(List<Integer> xs) {
        return reduce(xs, 0, Integer::sum);
    }

    static int sumOfSquaresOfEvenNumbersUpTo(int max) {
        return sum(square(filterEven(iterate(max))));
    }
}

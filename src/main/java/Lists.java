import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static <A> List<A> prepend(A x, List<A> xs) {
        var result = new ArrayList<A>(xs);
        result.add(0, x);
        return result;
    }

    public static <A> List<A> append(List<A> xs, A x) {
        var result = new ArrayList<A>(xs);
        result.add(x);
        return result;
    }

    public static <A> List<A> tail(List<A> xs) {
        return xs.size() <= 1 ? List.of() : xs.subList(1, xs.size());
    }

    public static <A> A head(List<A> xs) {
        return xs.get(0);
    }

    public static <A> List<A> concat(List<A> a, List<A> b) {
        var result = new ArrayList<A>(a);
        result.addAll(b);
        return result;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Lists {
    static <A> List<A> prepend(A x, List<A> xs) {
        var result = new LinkedList<>(xs);
        result.addFirst(x);
        return result;
    }

    static <A> List<A> append(List<A> xs, A x) {
        var result = new LinkedList<>(xs);
        result.addFirst(x);
        return result;
    }

    static <A> List<A> tail(List<A> xs) {
        return xs.size() <= 1 ? List.of() : xs.subList(1, xs.size());
    }

    static <A> A head(List<A> xs) {
        return xs.get(0);
    }

    static <A> List<A> concat(List<A> a, List<A> b) {
        var result = new ArrayList<>(a);
        result.addAll(b);
        return result;
    }
}

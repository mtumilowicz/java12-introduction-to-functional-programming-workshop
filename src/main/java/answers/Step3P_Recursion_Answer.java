package answers;

import io.vavr.collection.List;

public class Step3P_Recursion_Answer {
    
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
    
}

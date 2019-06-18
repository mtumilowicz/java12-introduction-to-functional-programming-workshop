import io.vavr.collection.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class C_RecursionTest {
    
    @Test
    public void test() {
        assertEquals(220, Step3_Recursion_Answer.sumOfSquaresOfEvenPositiveNumbersUpTo(10));
    }

    @Test
    public void testiteratePositiveUpTo() {
        assertEquals(List.of(1, 2, 3), Step3_Recursion_Answer.iteratePositiveUpTo(3));
    }

    @Test
    public void testSum() {
        assertEquals(6, Step3_Recursion_Answer.sum(List.of(1, 2, 3)));
    }

    @Test
    public void testFilterEvent() {
        assertEquals(List.of(2, 4), Step3_Recursion_Answer.filterEven(List.of(1, 2, 3, 4)));
    }

    @Test
    public void testSquare() {
        assertEquals(List.of(1, 4, 9, 16), Step3_Recursion_Answer.square(List.of(1, 2, 3, 4)));
    }
}

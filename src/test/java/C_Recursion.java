import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class C_Recursion {
    
    @Test
    public void test() {
        assertEquals(220, C_Recursion_Answer.sumOfSquaresOfEvenNumbersUpTo(10));
    }

    @Test
    public void testIterate() {
        assertEquals(List.of(1, 2, 3), C_Recursion_Answer.iterate(3));
    }

    @Test
    public void testSum() {
        assertEquals(6, C_Recursion_Answer.sum(List.of(1, 2, 3)));
    }

    @Test
    public void testFilterEvent() {
        assertEquals(List.of(2, 4), C_Recursion_Answer.filterEven(List.of(1, 2, 3, 4)));
    }

    @Test
    public void testSquare() {
        assertEquals(List.of(1, 4, 9, 16), C_Recursion_Answer.square(List.of(1, 2, 3, 4)));
    }
}

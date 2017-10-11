package Part_A;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Example1Test {

    @Test
    public void test() {
        assertEquals(0,Example1.addition(0,0));
        assertEquals(10,Example1.addition(10,0));
        assertEquals(7,Example1.addition(0,7));
        assertEquals(3,Example1.addition(1,2));
        assertEquals(-91,Example1.addition(-100,9));
        assertEquals(124,Example1.addition(212,-88));
    }
}
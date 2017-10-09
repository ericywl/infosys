package Part_A;

import org.junit.*;

import static org.junit.Assert.*;

public class TestCalculator {
    @Test
    public void testFourOperations() {
        // Enter your code here
        Calculator c = new Calculator();

        assertEquals("Failed Addition", 9, c.add(4, 5));
        assertEquals("Failed Subtraction", 2, c.sub(5, 3));
        assertEquals("Failed Multiplication", 42, c.mul(6, 7));
        assertEquals("Failed Division", 1, c.divInt(6, 4));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        Calculator c = new Calculator();
        c.divInt(1, 0);

    }

    // the main method
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("Part_A.TestCalculator");
    }
}



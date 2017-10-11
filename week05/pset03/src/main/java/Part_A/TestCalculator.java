package Part_A;

import junit.framework.*;
import junit.framework.Test;

public class TestCalculator extends TestCase {

    // constructor
    public TestCalculator(String name) {
        super(name);
    }

    public void testFourOperations() {
        // Enter your code here
        Calculator c = new Calculator();
        assertEquals("Failed Addition", 9, c.add(4, 5));
        assertEquals("Failed Subtraction", 2, c.sub(5, 3));
        assertEquals("Failed Multiplication", 42, c.mul(6, 7));
        assertEquals("Failed Division", 1, c.divInt(6, 4));
    }

    public void testDivideByZero() {
        Calculator c = new Calculator();
        try {
            // Enter your code here
            c.divInt(1, 0);
        } catch (IllegalArgumentException e) {
            // do nothing since exception has been correctly raised
        }
    }

    // method create a test suite
    public static Test suite() {
        return new TestSuite(TestCalculator.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}



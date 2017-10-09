package Part_A;

/**
 * Created by jit_biswas on 10/8/2017.
 */
import junit.framework.*;
import junit.framework.Test;

import org.junit.*;

public class TestCalculator extends TestCase {

    // constructor
    public TestCalculator (String name) {
        super(name);
    }

    @org.junit.Test
    public void testFourOperations () {
         // Enter your code here




    }

   @org.junit.Test
    public void testDivideByZero () {
        Calculator c = new Calculator();
        try {
             // Enter your code here



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



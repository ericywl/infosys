package Part_A;

/**
 * Created by jit_biswas on 10/8/2017.
 */
import junit.framework.*;
import junit.framework.Test;

import org.junit.*;

public class TestFindSmaller extends TestCase {

    // constructor
    public TestFindSmaller (String name) {
        super(name);
    }

    @org.junit.Test
    public void testFindingSmaller () {
         // Insert your code here


    }

    // method create a test suite
    public static Test suite() {
        return new TestSuite(TestFindSmaller.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}


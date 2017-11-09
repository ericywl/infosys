package eric.quiz2_2017.examples.Singleton;

import junit.framework.*;
import junit.framework.Test;


public class SingletonTest extends TestCase {
    private Singleton s1 = null;
    private Singleton  s2 = null;

    public SingletonTest(String name) {
        super(name);
    }
    public void testSuccessiveGetInstance() {
        s1 = Singleton.getInstance();
        s2 = Singleton.getInstance();
        TestCase.assertEquals(true, s1 == s2);
    }

    // method create a test suite
    public static Test suite() {
        return new TestSuite(SingletonTest.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
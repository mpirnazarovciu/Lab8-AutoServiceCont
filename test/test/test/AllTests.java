package test.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test for Auto Service");
        //$JUnit-BEGIN$
        suite.addTestSuite(TestR1_AutoService.class);
        suite.addTestSuite(TestR2_Drivers.class);
        suite.addTestSuite(TestR3_Services.class);
        //$JUnit-END$
        return suite;
    }

}

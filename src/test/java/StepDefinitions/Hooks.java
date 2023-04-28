package StepDefinitions;

import TestDrivers.TestDriver;
import io.cucumber.java.Before;


public class Hooks {

    @Before
    public void driverSetUp() {
        TestDriver.initialize();
    }

//    @After
//    public void tearDown() {
//        TestDriver.terminateDriver();
//    }

}

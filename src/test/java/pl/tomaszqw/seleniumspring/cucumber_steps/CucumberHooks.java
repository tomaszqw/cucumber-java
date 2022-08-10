package pl.tomaszqw.seleniumspring.cucumber_steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pl.tomaszqw.seleniumspring.driver_setup.DriverFactory;

public class CucumberHooks {

    @Before
    public void before() {
        System.out.println("Prepare data");
    }

    @After
    public void after() {
        DriverFactory.closeDriver();
    }
}

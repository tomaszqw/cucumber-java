package pl.tomaszqw.seleniumspring.cucumber_steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pl.tomaszqw.seleniumspring.driver_setup.DriverFactory;
import pl.tomaszqw.seleniumspring.utils.Utils;

public class CucumberHooks {

    Scenario scenario;
    WebDriver webDriver = DriverFactory.getWebDriver(System.getProperty("browser"));

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        System.out.println("Prepare data");
    }

    @After
    public void after() {
        Utils.takeScreenshot(webDriver, scenario);
        DriverFactory.closeDriver();
    }
}

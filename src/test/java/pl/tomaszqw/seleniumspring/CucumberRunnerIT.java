package pl.tomaszqw.seleniumspring;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-report.html"},
        features = "src/test/resources")
public class CucumberRunnerIT {
}

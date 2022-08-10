package pl.tomaszqw.seleniumspring.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {

    static String screenshotsDirectory = "./target/site/";

    public static void takeScreenshot(WebDriver webDriver, Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Screenshot: " + scenario.getName());
    }

    public static void clearData() {
        System.out.println("Clear data");
    }
}

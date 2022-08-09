package pl.tomaszqw.seleniumspring.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utils {

    static String screenshotsDirectory = "./target/site/";

    public static void takeScreenshot(WebDriver webDriver, String testName) throws IOException {
        File screenShotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile,
                new File(screenshotsDirectory + testName + "-" + screenShotFile.lastModified() + ".png"));
    }

    public static void takeScreenshotWhenTestFailed(WebDriver webDriver) {

    }

    public static void clearData() {
        System.out.println("Clear data");
    }
}

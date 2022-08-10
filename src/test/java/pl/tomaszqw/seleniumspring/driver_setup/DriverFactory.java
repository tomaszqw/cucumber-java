package pl.tomaszqw.seleniumspring.driver_setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    static WebDriver webDriver;

    public static WebDriver getWebDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(getChromeOptions());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver(getFirefoxOptions());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver(getEdgeOptions());
                break;
            default:
                throw new RuntimeException("Unsupported webdriver: " + browser);
        }
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }

    protected static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return chromeOptions;
    }

    protected static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return firefoxOptions;
    }

    protected static EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return edgeOptions;
    }
}

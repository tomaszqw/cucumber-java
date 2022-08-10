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

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static Map<String, WebDriver> webDrivers = new HashMap<>();

    public static WebDriver getWebDriver(String browser) {
        WebDriver webDriver;
        switch (browser) {
            case "chrome":
                webDriver = webDrivers.get(browser);
                if (webDriver == null) {
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver(getChromeOptions());
                    webDrivers.put(browser, webDriver);
                }
                break;
            case "firefox":
                webDriver = webDrivers.get(browser);
                if (webDriver == null) {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver(getFirefoxOptions());
                    webDrivers.put(browser, webDriver);
                }
                break;
            case "edge":
                webDriver = webDrivers.get(browser);
                if (webDriver == null) {
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver(getEdgeOptions());
                    webDrivers.put(browser, webDriver);
                }
                break;
            default:
                throw new RuntimeException("Unsupported webdriver: " + browser);
        }
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public static void closeDriver() {
        for (String key : webDrivers.keySet()) {
            webDrivers.get(key).close();
            webDrivers.get(key).quit();
        }
        webDrivers.clear();
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

package pl.tomaszqw.seleniumspring.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageObjectUtils {

    public static WebElement scrollToWebElement(WebDriver webDriver, WebElement webElement) {
        Actions action = new Actions(webDriver);
        action.scrollToElement(webElement).perform();
        return webElement;
    }
}

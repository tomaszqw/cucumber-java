package pl.tomaszqw.seleniumspring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Page {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

    @FindBy(how = How.XPATH, xpath = "//div[@class='login-box']/form//input[@id='user-name']")
    private WebElement loginInput;
    @FindBy(how = How.CSS, css = "div.login-box>form input#password")
    private WebElement passwordInput;
    @FindBy(how = How.ID, id = "login-button")
    private WebElement loginButton;

    private final By byXpathLoginErrorMessage =
            By.xpath("//div[@class='error-message-container error']/h3");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage goToMainPage() {
        webDriver.get(PAGE_URL);
        return (this);
    }

    public LoginPage fillLoginField(String login) {
        loginInput.sendKeys(login);
        return (this);
    }

    public LoginPage fillPasswordField(String password) {
        passwordInput.sendKeys(password);
        return (this);
    }

    public String getLoginErrorMessage() {
        return webDriver.findElement(byXpathLoginErrorMessage).getText();
    }

    public void clickLoginButton() {
        loginButton.submit();
    }
}

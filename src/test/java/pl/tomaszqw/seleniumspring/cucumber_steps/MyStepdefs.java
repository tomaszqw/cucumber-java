package pl.tomaszqw.seleniumspring.cucumber_steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pl.tomaszqw.seleniumspring.driver_setup.DriverFactory;
import pl.tomaszqw.seleniumspring.pages.LoginPage;

public class MyStepdefs {

    WebDriver webDriver;
    LoginPage loginPage;

    @Before
    public void before() {
        this.webDriver = DriverFactory.getWebDriver("chrome");
        this.loginPage = new LoginPage(webDriver);
    }

    @After
    public void after() {
        if (webDriver != null) {
            webDriver.quit();
        }

    }

    @Given("I go to the login page")
    public void iGoToTheLoginPage() {
        loginPage.goToMainPage();
    }

    @When("I fill login field with data {string}")
    public void iFillLoginFieldWithData(String login) {
        loginPage.fillLoginField(login);
    }

    @And("I fill password field with data {string}")
    public void iFillPasswordFieldWithData(String password) {
        loginPage.fillPasswordField(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see main page")
    public void iShouldSeeMainPage() throws InterruptedException {
        System.out.println("+++++++++++++++++++++++++");
        System.out.println("yeah");
        System.out.println("+++++++++++++++++++++++++");
        Thread.sleep(5000);
    }
}

package pl.tomaszqw.seleniumspring.cucumber_steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pl.tomaszqw.seleniumspring.driver_setup.DriverFactory;
import pl.tomaszqw.seleniumspring.pages.LoginPage;

public class MyStepdefs {

    LoginPage loginPage = new LoginPage(DriverFactory.getWebDriver(System.getProperty("browser")));

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
        Thread.sleep(5000);
        throw new PendingException();
    }
}

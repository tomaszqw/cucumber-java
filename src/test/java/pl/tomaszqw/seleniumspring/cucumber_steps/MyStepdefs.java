package pl.tomaszqw.seleniumspring.cucumber_steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pl.tomaszqw.seleniumspring.driver_setup.DriverFactory;
import pl.tomaszqw.seleniumspring.pages.LoginPage;
import pl.tomaszqw.seleniumspring.pages.MainPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStepdefs {

    private final static String BLOCKED_USER_ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";
    LoginPage loginPage = new LoginPage(DriverFactory.getWebDriver(System.getProperty("browser")));
    MainPage mainPage = new MainPage(DriverFactory.getWebDriver(System.getProperty("browser")));

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

    @Then("I should see login error message {string}")
    public void iShouldSeeLoginErrorMessage(String loginErrorMessage) {
        assertThat(loginPage.getLoginErrorMessage()).isEqualTo(loginErrorMessage);
    }

    @Then("I should see main page with products")
    public void iShouldSeeMainPageWithProducts(DataTable products) {
        List<List<String>> rows = products.asLists(String.class);
        int i = 1;
        for (List<String> tile : mainPage.getAllTiles()) {
            Assert.assertEquals(tile, rows.get(i));
            i++;
        }
    }
}

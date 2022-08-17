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

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStepdefs {

    private final static String BLOCKED_USER_ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";
    private final static String USERNAME_IS_REQUIRED_ERROR_MESSAGE =
            "Epic sadface: Username is required";
    private final static String INCORRECT_LOGIN_OR_PASSWORD_ERROR_MESSAGE = "Epic sadface: " +
            "Username and password do not match any user in this service";
    private final static String STANDARD_USER_LOGIN = "standard_user";
    private final static String PROBLEM_USER_LOGIN = "problem_user";
    private final static String PERFORMANCE_GLITCH_USER = "performance_glitch_user";
    private final static String BLOCKED_USER = "locked_out_user";
    private final static String userPassword = "secret_sauce";

    private final List<List<String>> expectedProducts = Arrays.asList(
            Arrays.asList("Sauce Labs Backpack",
                    "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style " +
                            "with unequaled laptop and tablet protection.",
                    "$29.99"),
            Arrays.asList("Sauce Labs Bike Light",
                    "A red light isn't the desired state in testing but it sure helps when riding your bike at " +
                            "night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                    "$9.99"),
            Arrays.asList("Sauce Labs Bolt T-Shirt",
                    "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% " +
                            "ringspun combed cotton, heather gray with red bolt.",
                    "$15.99"),
            Arrays.asList("Sauce Labs Fleece Jacket",
                    "It's not every day that you come across a midweight quarter-zip fleece jacket capable of " +
                            "handling everything from a relaxing day outdoors to a busy day at the office.",
                    "$49.99"),
            Arrays.asList("Sauce Labs Onesie",
                    "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap " +
                            "bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                    "$7.99"),
            Arrays.asList("Test.allTheThings() T-Shirt (Red)",
                    "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to " +
                            "automate a few tests. Super-soft and comfy ringspun combed cotton.",
                    "$15.99")
    );


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

    @When("I try login as a standard user")
    public void iLoginAsAStandardUser() {
        loginPage.fillLoginField(STANDARD_USER_LOGIN);
        loginPage.fillPasswordField(userPassword);
        loginPage.clickLoginButton();
    }

    @When("I try login as a problem user")
    public void iTryLoginAsAProblemUser() {
        loginPage.fillLoginField(PROBLEM_USER_LOGIN);
        loginPage.fillPasswordField(userPassword);
        loginPage.clickLoginButton();
    }

    @Then("I should see main page with appropriate products")
    public void iShouldSeeMainPageWithAppropriateProducts() {
        int i = 0;
        for (List<String> tile : mainPage.getAllTiles()) {
            Assert.assertEquals(tile, expectedProducts.get(i));
            i++;
        }
    }

    @When("I try login as a user with performance glitch")
    public void iTryLoginAsAUserWithPerformanceGlitch() {
        loginPage.fillLoginField(PERFORMANCE_GLITCH_USER);
        loginPage.fillPasswordField(userPassword);
        loginPage.clickLoginButton();
    }

    @When("I try login as a blocked user")
    public void iTryLoginAsABlockedUser() {
        loginPage.fillLoginField(BLOCKED_USER);
        loginPage.fillPasswordField(userPassword);
        loginPage.clickLoginButton();
    }

    @When("I fill login form with incorrect password")
    public void iFillLoginFormWithIncorrectPassword() {
        loginPage.fillLoginField(BLOCKED_USER);
        loginPage.fillPasswordField("incorrectPassword");
        loginPage.clickLoginButton();
    }

    @Then("I should see error message that user is blocked")
    public void iShouldSeeErrorMessageThatUserIsBlocked() {
        assertThat(loginPage.getLoginErrorMessage()).isEqualTo(BLOCKED_USER_ERROR_MESSAGE);
    }

    @Then("I should see error message that username is required")
    public void iShouldSeeErrorMessageThatUsernameIsRequired() {
        assertThat(loginPage.getLoginErrorMessage()).isEqualTo(USERNAME_IS_REQUIRED_ERROR_MESSAGE);
    }

    @Then("I should see error message that data is incorrect")
    public void iShouldSeeErrorMessageThatDataIsIncorrect() {
        assertThat(loginPage.getLoginErrorMessage()).isEqualTo(INCORRECT_LOGIN_OR_PASSWORD_ERROR_MESSAGE);
    }
}

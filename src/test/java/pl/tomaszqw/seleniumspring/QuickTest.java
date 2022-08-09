package pl.tomaszqw.seleniumspring;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tomaszqw.seleniumspring.driver_setup.DriverFactory;
import pl.tomaszqw.seleniumspring.pages.LoginPage;

@SpringBootTest
public class QuickTest {
    WebDriver webDriver;
    LoginPage loginPage;

    @BeforeEach
    public void init() {
        this.webDriver = DriverFactory.getWebDriver("chrome");
        this.loginPage = new LoginPage(webDriver);
    }

//    @Test
    public void successfulLogin() throws InterruptedException {
        loginPage.goToMainPage().fillLoginField("standard_user")
                .fillPasswordField("secret_sauce")
                .clickLoginButton();
        Thread.sleep(5000);
        webDriver.quit();
    }

    @AfterEach
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}

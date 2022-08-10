package pl.tomaszqw.seleniumspring;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tomaszqw.seleniumspring.driver_setup.DriverFactory;
import pl.tomaszqw.seleniumspring.pages.LoginPage;

@SpringBootTest
public class QuickTest {
    LoginPage loginPage = new LoginPage(DriverFactory.getWebDriver(System.getProperty("browser")));

    @Test
    public void successfulLogin() throws InterruptedException {
        loginPage.goToMainPage().fillLoginField("standard_user")
                .fillPasswordField("secret_sauce")
                .clickLoginButton();
        Thread.sleep(5000);
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}

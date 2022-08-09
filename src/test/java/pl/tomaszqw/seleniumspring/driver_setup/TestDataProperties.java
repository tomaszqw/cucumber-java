package pl.tomaszqw.seleniumspring.driver_setup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestDataProperties {

    @Value("chrome")
    private String browserName;

    public String getBrowserName() {
        return browserName;
    }
}

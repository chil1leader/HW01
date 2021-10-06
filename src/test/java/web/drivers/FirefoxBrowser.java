package web.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class FirefoxBrowser {
    public static WebDriver getDriver(LoadStrategyName loadStrategyName) {

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        options.addArguments("-private");
        options.addArguments("-kiosk");

        switch (loadStrategyName) {

            case NORMAL:
                options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);
                return new FirefoxDriver(options);
            case EAGER:
                options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.EAGER);
                return new FirefoxDriver(options);
            case NONE:
                options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NONE);
                return new FirefoxDriver(options);
            default:
                throw new RuntimeException("Incorrect load strategy name");
        }
    }
}

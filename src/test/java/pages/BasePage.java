package pages;

import helpers.JSExec;
import helpers.ScreenShot;
import helpers.WaitFor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        WaitFor.initWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        JSExec.initJS(driver);
        ScreenShot.initScreenShot(driver);
    }
}

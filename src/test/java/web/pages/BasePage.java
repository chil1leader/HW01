package web.pages;

import web.drivers.WebDriverFactory;
import web.helpers.ActionHelper;
import web.helpers.JavaScriptHelper;
import web.helpers.ScreenShot;
import web.helpers.WaitHelper;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        WaitHelper.initWait(WebDriverFactory.getCurrentDriver(),Duration.ofSeconds(10), Duration.ofMillis(100));
        JavaScriptHelper.initJS();
        ActionHelper.init();
    }
}

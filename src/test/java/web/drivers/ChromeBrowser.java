package web.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class ChromeBrowser {
    public static WebDriver getDriver(LoadStrategyName loadStrategyName) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        options.addArguments("--incognito");
        options.addArguments("--start-fullscreen");

        switch (loadStrategyName) {

            case NORMAL:
                options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);
                return new ChromeDriver(options);
            case EAGER:
                options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.EAGER);
                return new ChromeDriver(options);
            case NONE:
                options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NONE);
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("Некорректное имя стратегии загрузки");
        }
    }
}

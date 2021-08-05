import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Locale;

public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static WebDriver getDriver(String browserName, String loadStrategy) {
        switch (browserName) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                logger.info("Драйвер для браузера Google Chrome");
                logger.info("Load strategy: " + loadStrategy.toUpperCase());
                ChromeOptions optionsChrome = new ChromeOptions();

                optionsChrome.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                optionsChrome.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, false);
                optionsChrome.addArguments("--incognito");
                optionsChrome.addArguments("--start-maximized");

                switch (loadStrategy) {

                    case "normal":
                        optionsChrome.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                        return new ChromeDriver(optionsChrome);

                    case "eager":
                        optionsChrome.setPageLoadStrategy(PageLoadStrategy.EAGER);
                        return new ChromeDriver(optionsChrome);

                    case "none":
                        optionsChrome.setPageLoadStrategy(PageLoadStrategy.NONE);
                        return new ChromeDriver(optionsChrome);

                    default:
                        throw new RuntimeException("Incorrect load strategy name");

                }


            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                logger.info("Драйвер для браузера Mozilla Firefox");
                logger.info("Load strategy: " + loadStrategy.toUpperCase());
                FirefoxOptions optionsFF = new FirefoxOptions();

                optionsFF.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                optionsFF.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                optionsFF.addArguments("-private");
                optionsFF.addArguments("-kiosk");
                switch (loadStrategy) {

                    case "normal":
                        optionsFF.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                        return new FirefoxDriver(optionsFF);

                    case "eager":
                        optionsFF.setPageLoadStrategy(PageLoadStrategy.EAGER);
                        return new FirefoxDriver(optionsFF);

                    case "none":
                        optionsFF.setPageLoadStrategy(PageLoadStrategy.NONE);
                        return new FirefoxDriver(optionsFF);
                    default:
                        throw new RuntimeException("Incorrect load strategy name");

                }

            default:
                throw new RuntimeException("Incorrect browser name");
        }
    }
}

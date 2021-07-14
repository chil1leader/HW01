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
                ChromeOptions optionsChrome = new ChromeOptions();

                if (loadStrategy.equals("NORMAL".toLowerCase())) optionsChrome.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                else if (loadStrategy.equals("EAGER".toLowerCase())) optionsChrome.setPageLoadStrategy(PageLoadStrategy.EAGER);
                else optionsChrome.setPageLoadStrategy(PageLoadStrategy.NONE);

                optionsChrome.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                optionsChrome.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                optionsChrome.addArguments("--incognito");
                optionsChrome.addArguments("--start-maximized");
                //У меня  не работает полноэкранный режим через общие настройки, поэтому прописывал тут
                return new ChromeDriver(optionsChrome);

            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                logger.info("Драйвер для браузера Mozilla Firefox");
                FirefoxOptions optionsFF = new FirefoxOptions();

                if (loadStrategy.equals("NORMAL".toLowerCase())) optionsFF.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                else if (loadStrategy.equals("EAGER".toLowerCase())) optionsFF.setPageLoadStrategy(PageLoadStrategy.EAGER);
                else optionsFF.setPageLoadStrategy(PageLoadStrategy.NONE);

                optionsFF.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                optionsFF.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                optionsFF.addArguments("--incognito");
                optionsFF.addArguments("--start-maximized");
                //У меня  не работает полноэкранный режим через общие настройки, поэтому прописывал тут
                return new FirefoxDriver();

            default:
                throw new RuntimeException("Incorrect browser name");
        }
    }
}

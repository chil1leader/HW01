package webdriverfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static WebDriver getDriver(BrowserName browserName, LoadStrategyName loadStrategyName ) {
        switch (browserName) {
            case CHROME:
                logger.info("Драйвер браузера Google Chrome");
                return ChromeBrowser.getDriver(loadStrategyName);

            case FIREFOX:
                logger.info("Драйвер браузера Mozilla Firefox");
                return FirefoxBrowser.getDriver(loadStrategyName);

            default:
                throw new RuntimeException("Некорректное наименование браузера");
        }
    }
}

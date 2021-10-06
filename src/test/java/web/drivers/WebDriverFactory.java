package web.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);
    private static WebDriver webDriver;

    public static WebDriver getDriver(BrowserName browserName, LoadStrategyName loadStrategyName ) {
        switch (browserName) {
            case CHROME:
                logger.info("Драйвер браузера Google Chrome");
                webDriver = ChromeBrowser.getDriver(loadStrategyName);
                return webDriver;

            case FIREFOX:
                logger.info("Драйвер браузера Mozilla Firefox");
                webDriver =  FirefoxBrowser.getDriver(loadStrategyName);
                return webDriver;
            default:
                throw new RuntimeException("Некорректное наименование браузера");
        }
    }

    public static WebDriver getCurrentDriver() {
        return webDriver;
    }
}

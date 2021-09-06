package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import webdriverfactory.BrowserName;
import webdriverfactory.LoadStrategyName;
import webdriverfactory.WebDriverFactory;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeEach
    public void setUp() {
        String browser = System
                .getProperty("browser", "chrome")
                .toLowerCase();
        String loadStrategy = System
                .getProperty("option", "NORMAL")
                .toLowerCase();
        driver = WebDriverFactory.getDriver(BrowserName.fromString(browser), LoadStrategyName.fromString(loadStrategy));
        logger.info("Браузер: " + BrowserName.fromString(browser));
        logger.info("Стратегия загрузки: " + LoadStrategyName.fromString(loadStrategy));
        logger.info("Драйвер стартовал!");
    }

    @AfterEach
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}

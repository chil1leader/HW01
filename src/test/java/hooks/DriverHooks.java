package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.drivers.BrowserName;
import web.drivers.LoadStrategyName;
import web.drivers.WebDriverFactory;


public class DriverHooks {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(DriverHooks.class);

    @Before()
    public void startDriverBeforeScenario(Scenario scenario) {
        System.out.println(scenario.getId());
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        System.out.println(scenario.isFailed());
        System.out.println(scenario.getSourceTagNames());
        String browser = System
                .getProperty("browser", "chrome")
                .toLowerCase();
        String strategy = System
                .getProperty("option", "normal")
                .toLowerCase();
        driver = WebDriverFactory
                .getDriver(BrowserName.fromString(browser), LoadStrategyName.fromString(strategy));
        logger.info("Драйвер стартовал");

    }

    @After()
    public void stopDriverAfterScenario() {
        if(driver != null) {
            // Закрываем его
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}

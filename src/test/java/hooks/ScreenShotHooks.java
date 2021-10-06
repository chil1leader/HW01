package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import web.drivers.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class ScreenShotHooks {

    private Logger logger = LogManager.getLogger(ScreenShotHooks.class);

    @BeforeStep
    public void takeScreenShotBeforeStep(Scenario scenario) {
        try {
            Date date = new Date();
            TakesScreenshot screenshot = (TakesScreenshot) WebDriverFactory.getCurrentDriver();
            String pathName = "temp/fileName.png".replace("fileName", scenario.getName() + date.getTime());
            Thread.sleep(1000);
            logger.info("Скриншот сохранен в файле " + pathName + ".png");
            File screenshotOfPage = screenshot.getScreenshotAs(OutputType.FILE);
            File path = new File(pathName);
            FileUtils.copyFile(screenshotOfPage, path);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterStep
    public void takeScreenShotAfterStep(Scenario scenario) {
        try {
            Date date = new Date();
            TakesScreenshot screenshot = (TakesScreenshot) WebDriverFactory.getCurrentDriver();
            String pathName = "temp/fileName.png".replace("fileName", scenario.getName() + date.getTime());
            Thread.sleep(1000);
            logger.info("Скриншот сохранен в файле " + pathName + ".png");
            File screenshotOfPage = screenshot.getScreenshotAs(OutputType.FILE);
            File path = new File(pathName);
            FileUtils.copyFile(screenshotOfPage, path);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

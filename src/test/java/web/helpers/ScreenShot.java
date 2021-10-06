package web.helpers;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenShot {
    private static Logger logger = LogManager.getLogger(ScreenShot.class);
    protected static TakesScreenshot screenshot;

    public static void initScreenShot(WebDriver driver) { screenshot = ((TakesScreenshot)driver); }

    public static void takeScreenshot(Date date, String name){

        try {
                String pathName = "temp\\fileName.png".replace("fileName", name + date.getTime());
                Thread.sleep(2500);
                logger.info("Скриншот сохранен в файле " + pathName + ".png");
                File screenshotOfPage = screenshot.getScreenshotAs(OutputType.FILE);
                File path = new File(pathName);
                FileUtils.copyFile(screenshotOfPage, path);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
        }
    }
}

package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenShot {
    private static Logger logger = LogManager.getLogger(ScreenShot.class);
    protected static Screenshot screenshot;

    public static void initScreenShot(WebDriver driver) { screenshot = new AShot().takeScreenshot(driver); }

    public static void takeScreenshot(Date date, String name){

        try {
                String pathName = "temp\\fileName.png".replace("fileName", name + String.valueOf(date.getTime()));
                ImageIO.write(screenshot.getImage(), "png", new File(pathName));
                logger.info("Скриншот сохранен в файле " + pathName + ".png");
            } catch (IOException e) {
                e.printStackTrace();
        }
    }
}

package web.helpers;

import org.apache.logging.log4j.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import web.drivers.WebDriverFactory;

public class WindowHelper {

    private static Logger logger = LogManager.getLogger(WindowHelper.class);

    public static void maximizeWindow() {


        WebDriverFactory.getCurrentDriver().manage().window().maximize();
    }

    public static void minimizeWindow() {
        WebDriverFactory.getCurrentDriver().manage().window().minimize();
    }

    public static void fullscreenWindow() {
        WebDriverFactory.getCurrentDriver().manage().window().fullscreen();
    }

    public static Point getWindowPosition() {
        return WebDriverFactory.getCurrentDriver().manage().window().getPosition();
    }

    public static void setWindowPosition(Point point) {
        WebDriverFactory.getCurrentDriver().manage().window().setPosition(point);
    }

    public static Dimension getWindowSize() {
        return WebDriverFactory.getCurrentDriver().manage().window().getSize();
    }

    public static void setWindowSize(Dimension dimension) {
        WebDriverFactory.getCurrentDriver().manage().window().setSize(dimension);
    }


}

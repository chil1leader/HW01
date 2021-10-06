package web.helpers;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WindowType;
import web.drivers.WebDriverFactory;

public class SwitchHelper {

    private static Logger logger = LogManager.getLogger(SwitchHelper.class);
    public static void switchToExistWindow(String window) {
        WebDriverFactory.getCurrentDriver().switchTo().window(window);
    }

    public static void switchToNewWindow() {
        WebDriverFactory.getCurrentDriver().switchTo().newWindow(WindowType.WINDOW);
    }

    public static void switchToNewTab() {
        WebDriverFactory.getCurrentDriver().switchTo().newWindow(WindowType.TAB);
    }

    public static void switchToAlert() {
        WebDriverFactory.getCurrentDriver().switchTo().alert();
    }

    public static void switchToFrameByIndex(int index) {
        WebDriverFactory.getCurrentDriver().switchTo().frame(index);
    }

    public static void switchToFrameByNameOrId(String nameOrId) {
        WebDriverFactory.getCurrentDriver().switchTo().frame(nameOrId);
    }

    public static void switchToParentFrame() {
        WebDriverFactory.getCurrentDriver().switchTo().parentFrame();
    }

    public static void switchToDefaultContent() {
        WebDriverFactory.getCurrentDriver().switchTo().defaultContent();
    }

    public static void switchToActiveWebElement() {
        WebDriverFactory.getCurrentDriver().switchTo().activeElement();
    }

}

package web.helpers;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import web.drivers.WebDriverFactory;


public class ActionHelper {
    private static Logger logger = LogManager.getLogger(ActionHelper.class);
    private static Actions actions;

    public static void init() {
        actions = new Actions(WebDriverFactory.getCurrentDriver());
    }

    public static void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    public static void clickElement(WebElement webElement) { actions.moveToElement(webElement).click().build().perform();}

}

package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.drivers.WebDriverFactory;

public class JavaScriptHelper {
    private Logger logger = LogManager.getLogger(JavaScriptHelper.class);
    protected static JavascriptExecutor js;

    public static void initJS() {
        js = (JavascriptExecutor) WebDriverFactory.getCurrentDriver();
    }

    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        js.executeScript(script);
    }

    public static void displayNone(WebElement element) {
        String script = "arguments[0].style.display='none';";
        js.executeScript(script, element);
    }
}
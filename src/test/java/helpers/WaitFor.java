package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitFor {

    private static Logger logger = LogManager.getLogger(WaitFor.class);
    protected static WebDriverWait wait;


    public static void initWait(WebDriver driver, Duration timeOut, Duration sleep) {
        wait = new WebDriverWait(driver, timeOut, sleep);

    }

    public static void presenceOfElementLocated(By webElement) {
        wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
    }

    public static void presenceOfTextInElement(WebElement webElement, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    public static void clickabilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void clickabilityOfElementLocated(By webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void visibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void visibilityOfElementLocated(By webElement) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
    }

    public static void firstProductMustBe(By webElement, String product) {
        wait.until((ExpectedCondition<Boolean>) webDriver ->
                webDriver.findElement(webElement).getText().contains(product));
    }
}

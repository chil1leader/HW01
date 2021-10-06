package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BaseElement {
    protected WebDriver driver;
    protected By by;
    protected WebElement webElement;
    protected Actions action;


    public BaseElement(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
        action = new Actions(driver);
        WaitFor.initWait(driver, Duration.ofMillis(10000), Duration.ofMillis(300));
        WaitFor.presenceOfElementLocated(by);
        WaitFor.visibilityOfElementLocated(by);
        webElement = driver.findElement(by);
    }

    public WebElement getWebElement() {
        return webElement;
    }
    public String getText() {return webElement.getText(); }
}
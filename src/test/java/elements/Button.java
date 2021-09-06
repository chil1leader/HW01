package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends BaseElement {
    public Button(WebDriver driver, By by) {
        super(driver, by);
    }

    public void click() {
        WaitFor.visibilityOfElementLocated(by);
        WaitFor.clickabilityOfElement(webElement);
        action.moveToElement(webElement).click().build().perform();
    }
}
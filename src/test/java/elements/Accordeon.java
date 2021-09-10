package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Accordeon extends BaseElement {
    public Accordeon(WebDriver driver, By by) {
        super(driver, by);
    }

    public void show() {
        WaitFor.visibilityOfElement(webElement);
        WaitFor.clickabilityOfElement(webElement);
        action.moveToElement(webElement).click().build().perform();
    }
}

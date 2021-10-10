package web.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import web.drivers.WebDriverFactory;
import web.helpers.ActionHelper;
import web.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Accordeon extends BaseElement {

    public Accordeon(WebElement webElement) {
        super(webElement);
    }


    public void show() {
        WaitHelper.clickabilityOfElement(webElement);
        ActionHelper.clickElement(webElement);
    }
}
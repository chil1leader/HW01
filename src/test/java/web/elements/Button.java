package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.ActionHelper;
import web.helpers.WaitHelper;


public class Button extends BaseElement {

    public Button(WebElement webElement) {
        super(webElement);
    }


    public void click() {

        WaitHelper.clickabilityOfElement(webElement);
        ActionHelper.clickElement(webElement);
    }
}
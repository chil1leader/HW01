package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.ActionHelper;


public class BaseElement {

    protected WebElement webElement;


    public BaseElement(WebElement webElement) {
        this.webElement = webElement;
        ActionHelper.init();
    }


    public WebElement getWebElement() {
        return webElement;
    }
}
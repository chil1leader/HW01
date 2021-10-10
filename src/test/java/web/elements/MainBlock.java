package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.JavaScriptHelper;


public class MainBlock extends BaseElement {

    public MainBlock(WebElement webElement) {
        super(webElement);
    }


    public void hide() {
        JavaScriptHelper.displayNone(webElement);
    }
}
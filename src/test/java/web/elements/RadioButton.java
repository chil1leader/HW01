package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.ActionHelper;
import web.helpers.WaitHelper;


public class RadioButton extends BaseElement {

    public RadioButton(WebElement webElement) {
        super(webElement);
    }


    public void setSelected(boolean value) {

        WaitHelper.clickabilityOfElement(webElement);
        if (value != isSelected()) {
            ActionHelper.clickElement(webElement);
        }
    }


    public boolean isSelected() {
        return webElement.isSelected();
    }
}
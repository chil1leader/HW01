package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.ActionHelper;
import web.helpers.WaitHelper;


public class CheckBox extends BaseElement {

    public CheckBox(WebElement webElement) {
        super(webElement);
    }


    public void setChecked(boolean value) {

        WaitHelper.clickabilityOfElement(webElement);
        if (value != isChecked()) {
            ActionHelper.clickElement(webElement);
        }
    }


    public boolean isChecked() {
        return webElement.isSelected();
    }
}

package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton extends BaseElement{
    public RadioButton(WebDriver driver, By by) {
        super(driver, by);
    }

    public void setSelected(boolean value) {
        if (value != isSelected()) {
            WaitFor.clickabilityOfElement(webElement);
            action.moveToElement(webElement).click().build().perform();
        }
    }

    public boolean isSelected() {
        WaitFor.visibilityOfElementLocated(by);
        return webElement.isSelected();
    }
}
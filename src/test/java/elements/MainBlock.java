package elements;

import helpers.JSExec;
import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainBlock extends BaseElement {
    public MainBlock(WebDriver driver, By by) {
        super(driver, by);
    }

    public void hide() {
        WaitFor.visibilityOfElementLocated(by);
        JSExec.displayNone(webElement);
    }
}

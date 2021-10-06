package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.ActionHelper;
import web.helpers.WaitHelper;

// Класс "Текстовое поле ввода"
public class TextBox extends BaseElement {
    // Конструктор
    public TextBox(WebElement webElement) {
        super(webElement);
    }

    // Нажатие на текстовое поле ввода
    public void click() {
        // Ожидание кликабельности флажка текстового поля ввода
        WaitHelper.clickabilityOfElement(webElement);
        ActionHelper.clickElement(webElement);
    }

    // Ввод значения в текстовое поле ввода
    public void setValue(String value) {
        // Ожидание кликабельности флажка текстового поля ввода
        WaitHelper.clickabilityOfElement(webElement);
        webElement.sendKeys(value);
    }
}
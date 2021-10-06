package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.ActionHelper;
import web.helpers.WaitHelper;

// Класс "Флажок"
public class CheckBox extends BaseElement {
    // Конструктор
    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    // Установка флажка
    public void setChecked(boolean value) {
        // Ожидание кликабельности флажка
        WaitHelper.clickabilityOfElement(webElement);
        if (value != isChecked()) {
            ActionHelper.clickElement(webElement);
        }
    }

    // Проверка, что флажок установлен
    public boolean isChecked() {
        return webElement.isSelected();
    }
}

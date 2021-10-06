package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.ActionHelper;

// Базовый класс для всех веб элементов
public class BaseElement {
    // Веб элемент
    protected WebElement webElement;


    // Конструктор класса
    public BaseElement(WebElement webElement) {
        this.webElement = webElement;
        ActionHelper.init();
    }

    // Получение оборачиваемого веб элемента
    // Получив оборачиваемый веб элемент, можно вызвать его методы
    // Например, getText()
    public WebElement getWebElement() {
        return webElement;
    }
}
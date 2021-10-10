package web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.drivers.WebDriverFactory;
import web.helpers.WaitHelper;

// Класс "Таблица"
public class Table extends BaseElement {
    // Конструктор
    public Table(WebElement webElement) {
        super(webElement);
    }

    // Получение значения ячеек таблицы
    public String getDataValue(String dataName) {

        String xpath = "//table//*[contains(text(), \"" + dataName + "\")]/following::td[1]";
        return webElement.findElement(By.xpath(xpath)).getText();
    }
}

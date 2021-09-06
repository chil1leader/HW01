package pages;

import elements.BaseElement;
import elements.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TvProductPage extends BasePage {

    private Logger logger = LogManager.getLogger(TvProductPage.class);

    public TvProductPage(WebDriver driver) { super(driver);}

    String characteristicsXpath = "//a[text()='Характеристики']";
    String actualCompanyXpath = "//table//*[contains(text(), 'Модель')]/following::td[1]";
    String actualScreenSizeXpath = "//table//*[contains(text(), 'Диагональ экрана (дюйм)')]/following::td[1]";
    String actualRefreshRateXpath = "//table//*[contains(text(), 'Частота обновления экрана')]/following::td[1]";
    String actualBacklightXpath = "//table//*[contains(text(), 'Тип подсветки экрана')]/following::td[1]";

    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Заголовок страницы: " + title);
        return title;
    }

    public void btnCharacteristicsClick() {
        Button characteristics = new Button(driver, By.xpath(characteristicsXpath));
        characteristics.click();
        logger.info("Открыт раздел \"Характеристики\"");

    }
    public String getProductCompany() {
        BaseElement actualCompany =  new BaseElement(driver,By.xpath(actualCompanyXpath));
        logger.info("Актуальная компания: " + actualCompany.getText());
        return actualCompany.getText();
    }

    public String getProductScreenSize() {
        BaseElement actualScreenSize = new BaseElement(driver, By.xpath(actualScreenSizeXpath));
        logger.info("Актуальная диагональ экрана: " + actualScreenSize.getText());
        return actualScreenSize.getText();
    }

    public String getProductRefreshRate() {
        BaseElement actualRefreshRate = new BaseElement(driver, By.xpath(actualRefreshRateXpath));
        logger.info("Актуальная частота обновления экрана: " + actualRefreshRate.getText());
        return actualRefreshRate.getText();
    }

    public String getProductBacklight() {
        BaseElement actualBacklight = new BaseElement(driver, By.xpath(actualBacklightXpath));
        logger.info("Актуальный тип подсветки экрана: " + actualBacklight.getText());
        return actualBacklight.getText();
    }
}

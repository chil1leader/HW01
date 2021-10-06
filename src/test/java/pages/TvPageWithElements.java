package pages;

import elements.*;
import helpers.ScreenShot;
import helpers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class TvPageWithElements extends BasePage {

    private Logger logger = LogManager.getLogger(TvPageWithElements.class);

    public TvPageWithElements(WebDriver driver) {
        super(driver);
    }

    String mainBlockXpath = "//header";
    String btnApplyXpath = "//button[contains(text(), \"Применить\")]";

    String chbxCompanyXpath = "//span[contains(text(), \"company\")]";

    String accordeonSizeScreenXpath = "//span[contains(text(), \"Диагональ\")]";
    String txtbxMinSizeScreen = "//div[6]//div[1]/input";
    String txtbxMaxSizeScreen = "//div[6]//div[2]/input";

    String accordeonRefreshRateXpath = "//span[contains(text(), \"Частота\")]";
    String chbxRefreshRateXpath = "//span[contains(text(), \"rate\")]";

    String accordeonBacklightXpath = "//span[contains(text(), \"Тип подсветки экрана\")]";
    String chbxBacklightXpath = "//span[contains(text(), \"backlight\")]";

    String accordeonSortXpath = "//div[@id='sort-filter']/div[2]//span[.='Сначала недорогие']";
    String rbtnExpensiveXpath = "//span[contains(text(), \"Сначала дорогие\")]";
    String linkFirstProductXpath = "(//a[contains(@class, \"catalog-product__name\")])[1]";

    public void mainBlockHide() {
        MainBlock mainBlock = new MainBlock(driver, By.xpath(mainBlockXpath));
        mainBlock.hide();
    }

    public void chbxCompanyClick(String company) {
        chbxCompanyXpath = chbxCompanyXpath.replace("company", company);
        CheckBox chbxCompany = new CheckBox(driver, By.xpath(chbxCompanyXpath));
        chbxCompany.setChecked(true);
        logger.info("Установлен фильтр \"Производитель\" - " + company);
    }

    public void accordeonSizeScreenClick() {
        Accordeon accordeonRAM = new Accordeon(driver, By.xpath(accordeonSizeScreenXpath));
        accordeonRAM.show();
        logger.info("Отображены значения фильтра \"Диагональ экрана\"");
    }

    public void txtbxSizeScreenSetValue(int minSize, int maxSize) {
        TextBox txtbxMinSize = new TextBox(driver, By.xpath(txtbxMinSizeScreen));
        txtbxMinSize.setValue(String.valueOf(minSize));
        TextBox txtbxMaxSize = new TextBox(driver, By.xpath(txtbxMaxSizeScreen));
        txtbxMaxSize.setValue(String.valueOf(maxSize));
        logger.info("Установлен фильтр \"Диагональ экрана\" от " + minSize + " до " + maxSize + " дюймов");


    }

    public void accordeonRefreshRateClick() {
        Accordeon accordeonRefreshRate = new Accordeon(driver, By.xpath(accordeonRefreshRateXpath));
        accordeonRefreshRate.show();
        logger.info("Отображены значения фильтра \"Частота обновления экрана\"");
    }

    public void chbxRefreshRateClick(String rate) {
        chbxRefreshRateXpath = chbxRefreshRateXpath.replace("rate", rate);
        CheckBox chbxRefreshRate = new CheckBox(driver, By.xpath(chbxRefreshRateXpath));
        chbxRefreshRate.setChecked(true);
        logger.info("Установлен фильтр \"Частота обновления экрана\" - " + rate);
    }

    public void accordeonBacklightClick() {
        Accordeon accordeonBacklight = new Accordeon(driver, By.xpath(accordeonBacklightXpath));
        accordeonBacklight.show();
        logger.info("Отображены значения фильтра \"Тип подсветки экрана\"");
    }

    public void chbxBacklightClick(String backlight) {
        chbxBacklightXpath = chbxBacklightXpath.replace("backlight", backlight);
        CheckBox chbxBacklight = new CheckBox(driver, By.xpath(chbxBacklightXpath));
        chbxBacklight.setChecked(true);
        logger.info("Установлен фильтр \"Тип подсветки экрана\" - " + backlight);
    }

    public void accordeonSortClick() {
        driver.navigate().refresh();
        Accordeon accordeonSort = new Accordeon(driver, By.xpath(accordeonSortXpath));
        accordeonSort.show();
        logger.info("Нажата выпадашка \"Сортировка\"");
    }

    public void rbtnExpensiveClick() {
        RadioButton rbtnExpensive = new RadioButton(driver, By.xpath(rbtnExpensiveXpath));
        rbtnExpensive.setSelected(true);
        logger.info("Установлена сортировка - \"Сначала дорогие\"");
    }

    public void linkFirstProductClick(String product) {
        WaitFor.firstProductMustBe(By.xpath(linkFirstProductXpath), product);
        Link linkProduct = new Link(driver, By.xpath(linkFirstProductXpath));
        linkProduct.openInNewWindow();
        logger.info("Нажата ссылка первого продукта в списке");
    }

    public void btnApplyClick() {
        Button btnApply = new Button(driver, By.xpath(btnApplyXpath));
        btnApply.click();
        logger.info("Нажата кнопка \"Применить\"");

    }

}

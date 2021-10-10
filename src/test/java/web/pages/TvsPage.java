package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;
import web.elements.*;
import web.helpers.WaitHelper;

import java.time.Duration;

public class TvsPage extends BasePage {

    private Logger logger = LogManager.getLogger(TvsPage.class);


    @FindBy(xpath = "//header")
    private WebElement mainBlock;

    @FindBy(xpath = "//button[contains(text(), \"Применить\")]")
    private WebElement buttonApply;

    @FindBy(xpath = "//span[text()=\"Производитель\"]/parent::a/following-sibling::div//div[@class=\"ui-checkbox-group ui-checkbox-group_list\"]")
    private WebElement divCompany;

    @FindBy(xpath = "//div[@class='ui-list-controls__content']/a[1]/span[.='Показать всё']")
    private WebElement fullDivCompany;

    @FindBy(xpath = "//span[contains(text(), \"Диагональ\")]")
    private WebElement accordeonSizeScreen;

    @FindBy(xpath = "//div[6]//div[1]/input")
    private WebElement txtbxMinSizeScreen;

    @FindBy(xpath = "//div[6]//div[2]/input")
    private WebElement txtbxMaxSizeScreen;

    @FindBy(xpath = "//span[contains(text(), \"Частота\")]")
    private WebElement accordeonRefreshRate;

    @FindBy(xpath = "//span[text()=\"Частота обновления экрана (Гц)\"]/parent::a/following-sibling::div//div[@class=\"ui-checkbox-group ui-checkbox-group_list\"]")
    private WebElement divRate;

    @FindBy(xpath = "//span[contains(text(), \"Тип подсветки экрана\")]")
    private WebElement accordeonBacklight;

    @FindBy(xpath = "//span[text()=\"Тип подсветки экрана\"]/parent::a/following-sibling::div//div[@class=\"ui-checkbox-group ui-checkbox-group_list\"]")
    private WebElement divBacklight;


    @FindBy(xpath = "//div[@id='sort-filter']/div[2]//span[2]")
    private WebElement accordeonSort;
    @FindBy(xpath = "(//div[@class=\"top-filter__radio-list ui-radio top-filter__popover\"])[1]")
    private WebElement divSort;
    @FindBy(xpath = "(//a[contains(@class, \"catalog-product__name\")])[1]")
    private WebElement linkFirstProduct;

    public TvsPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainBlock mainBlock() {
        return new MainBlock(mainBlock);
    }

    public Link fullDivCompany() {
        return new Link(fullDivCompany);
    }

    public CheckBox chbxCompany(String company) {
        return new CheckBox(findCheckBoxCompany(company));
    }

    public WebElement findCheckBoxCompany(String company) {
        WaitHelper.visibilityOfElement(divCompany);
        return divCompany.findElement(By.xpath("./label/span[contains(text(), \"" + company + "\")]"));

    }

    public Accordeon accordeonSizeScreen() {
        return new Accordeon(accordeonSizeScreen);
    }

    public TextBox txtbxMinSize() {
        return new TextBox(txtbxMinSizeScreen);
    }

    public TextBox txtbxMaxSize() {
        return new TextBox(txtbxMaxSizeScreen);
    }


    public Accordeon accordeonRefreshRate() {
        return new Accordeon(accordeonRefreshRate);
    }

    public CheckBox chbxRefreshRate(String rate) {
        return new CheckBox(findCheckBoxRefreshRate(rate));
    }

    private WebElement findCheckBoxRefreshRate(String rate) {
        WaitHelper.visibilityOfElement(divRate);
        return divRate.findElement(By.xpath("./label/span[contains(text(), \"" + rate + "\")]"));
    }

    public Accordeon accordeonBacklight() {
        return new Accordeon(accordeonBacklight);
    }

    public CheckBox chbxBacklight(String backlight) {
        return new CheckBox(findCheckBoxBackLight(backlight));
    }

    private WebElement findCheckBoxBackLight(String backlight) {
        WaitHelper.visibilityOfElement(divBacklight);
        return divBacklight.findElement(By.xpath("./label/span[contains(text(), \"" + backlight + "\")]"));
    }


    public Button buttonApply() {
        return new Button(buttonApply);
    }


    public Accordeon accordeonSort() {
        return new Accordeon(accordeonSort);
    }


    public RadioButton radioButtonSort(String sort) {
        return new RadioButton(findRadioButtonSort(sort));
    }


    private WebElement findRadioButtonSort(String sort) {
        WaitHelper.visibilityOfElement(divSort);
        return divSort.findElement(By.xpath("//span[contains(text(), \"" + sort + "\")]"));
    }


    public Link linkFirstProduct() {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Link(linkFirstProduct);
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Заголовок страницы: " + title);
        return title;
    }

}

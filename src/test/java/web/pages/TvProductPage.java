package web.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.*;
import web.helpers.WaitHelper;

public class TvProductPage extends BasePage {

    private Logger logger = LogManager.getLogger(TvProductPage.class);

    @FindBy(xpath = "//a[text()='Характеристики']" )
    private WebElement characteristicsLink;

    @FindBy(xpath = "//table")
    private WebElement characteristicsTable;


    public TvProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        ;}

    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Заголовок страницы: " + title);
        return title;
    }

    public Link characteristicsLink() {return new Link(characteristicsLink);}

    public Table tableCharacteristics() {
        WaitHelper.visibilityOfElement(characteristicsTable);
        return new Table(characteristicsTable);
    }


}

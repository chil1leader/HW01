package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;


public class StartPage extends BasePage {

    private Logger logger = LogManager.getLogger(StartPage.class);


    @FindBy(xpath = "//a[contains(text(),\"Да\")]")
    private WebElement linkYes;
    @FindBy(xpath = "(//a[contains(text(), \"ТВ и мультимедиа\")])[1]")
    private WebElement linkTvAndMultimedia;
    @FindBy(xpath = "//a[text()=\"Телевизоры\"]")
    private WebElement linkTv;

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public Link linkYes() {
        return new Link(linkYes);
    }

    public Link linkTvAndMultimedia() {
        return new Link(linkTvAndMultimedia);
    }

    public Link linkTvs() {
        return new Link(linkTv);
    }
}
package pages;

import elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPageWithElements extends BasePage {

    private Logger logger = LogManager.getLogger(StartPageWithElements.class);
    private final String URL = "https://www.dns-shop.ru/";

    String linkYesXpath = "//a[contains(text(),\"Да\")]";
    String linkTvAndMultimediaXpath = "//a[@href='/catalog/17a8bfb516404e77/tv-i-multimedia/']";
    String linkTvXpath = "//a[@href='/catalog/17a8ae4916404e77/televizory/']";

    public StartPageWithElements(WebDriver driver) {
        super(driver);
    }

    public String getURL() {
        return this.URL;
    }

    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    public void linkYesClick() {
        Link linkYes = new Link(driver, By.xpath(linkYesXpath));
        linkYes.click();
        logger.info("Нажата кнопка \"Да\"");
    }

    public void linkTvAndMultimediaMove() {
        Link linkTvAndMultimedia = new Link(driver, By.xpath(linkTvAndMultimediaXpath));
        linkTvAndMultimedia.focusOnLink();
        logger.info("Курсор мыши наведен на ссылку \"Телевизоры\"");
    }

    public void linkTVClick() {
        Link linkTV = new Link(driver, By.xpath(linkTvXpath));
        linkTV.click();
        logger.info("Нажата ссылка \"Телевизоры\"");
    }
}

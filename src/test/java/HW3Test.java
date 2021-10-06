import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class HW3Test {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(HW3Test.class);
    String env = System.getProperty("browser", "chrome");
    String load = System.getProperty("option", "NORMAL");

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver(env.toLowerCase(), load.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }

    @Test
    public void FilterSamsungPhoneTest() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Открыть страницу DNS
        driver.get("https://www.dns-shop.ru");
        logger.info("Открыта страница dns-shop.ru");

        //Закрыть всплывашку
        By AcceptLocationBtnXpath = By.linkText("Да");
        WebElement AcceptLocationBtn = driver.findElement(AcceptLocationBtnXpath);
        wait.until(ExpectedConditions.elementToBeClickable(AcceptLocationBtn)).click();
        logger.info("Всплывашка закрыта");

        //Навести мышь на элемент Смартфоны и гаджеты
        By PhonesBtnXpath = By.xpath(
                "//div[@id='homepage-desktop-menu-wrap']/div[@class='menu-desktop']//a[@href='/catalog/17a890dc16404e77/smartfony-planshety-i-fototexnika/']");
        Actions action = new Actions(driver);
        WebElement PhonesBtn = driver.findElement(PhonesBtnXpath);
        action.moveToElement(PhonesBtn).build().perform();

        //Открыть раздел Смарфтоны
        WebElement PhonesListBtn = driver.findElement(By.xpath(
                "//div[@id='homepage-desktop-menu-wrap']/div[@class='menu-desktop']/div[2]/div[@class='menu-desktop__submenu menu-desktop__submenu_top']//a[@href='/catalog/17a8a01d16404e77/smartfony/']"));
        logger.info("Открыт раздел: " + PhonesListBtn.getText());
        PhonesListBtn.click();

        //Сделать скриншот страницы
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage PageOfPhones = ImageIO.read(file);
            ImageIO.write(PageOfPhones, "png", new File("C:\\Users\\Artyom\\IdeaProjects\\hw1\\screenshots\\PhonesPage.png"));
            logger.info("Скриншот сохранен в файле [C:\\Users\\Artyom\\IdeaProjects\\hw1\\PhonesPage.png]");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Скроллинг страницы
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "window.scrollBy(0,1000);";
        String script2 = "window.scrollBy(0,2000);";
        js.executeScript(script);
        logger.info("Проскроллено вниз на 1000px");

        //Открыть фильтр Производитель
        WebElement BrandOptionList = driver.findElement(By.cssSelector("" +
                ".ui-link.ui-link_blue.ui-link_pseudolink.ui-list-controls__link.ui-list-controls__link_fold > span"));
        wait.until(ExpectedConditions.elementToBeClickable(BrandOptionList)).click();
        logger.info("Открыт фильтр \"Производитель\"");

        //Выбрать значение в фильтре Производитель
        By BrandOptionXpath = By.xpath(
                "//div[@class=\"ui-checkbox-group ui-checkbox-group_list\"]//*[contains(text(), 'Samsung')]");
        WebElement BrandOptionBtn = driver.findElement(BrandOptionXpath);
        wait.until(ExpectedConditions.elementToBeClickable(BrandOptionBtn)).click();
        logger.info("Выбран производитель: " + BrandOptionBtn.getText());

        //Скроллинг
        js.executeScript(script2);
        logger.info("Проскроллено вниз на 2000px");

        ////Открыть фильтр Объем оперативной памятя
        WebElement RAMOptionList = driver.findElement(By.cssSelector(
                "div:nth-of-type(8) > .ui-collapse__link.ui-collapse__link_left.ui-collapse__link_list.ui-link > .ui-collapse__link-text"));
        wait.until(ExpectedConditions.elementToBeClickable(RAMOptionList));
        RAMOptionList.click();
        logger.info("Открыт фильтр \"Оперативная память\"");

        //Выбрать значение в фильтре Объем оперативной памяти
        WebElement RAMOptionBtn = driver.findElement(By.xpath(
                "//div[@class='products-page']/div[@class='products-page__content']/div[1]/div[@class='inner-wrapper-sticky']/div[@class='left-filters']/div[@class='left-filters__list']/div[8]/div/div[@class='ui-list-controls__content']/div[@class='ui-checkbox-group ui-checkbox-group_list']/label[6]"));
        wait.until(ExpectedConditions.elementToBeClickable(RAMOptionBtn));
        action.moveToElement(RAMOptionBtn).click().build().perform();
        logger.info("Выбрана оперативная память: " + RAMOptionBtn.getText());

        //Скроллинг
        js.executeScript(script);
        logger.info("Проскроллено вниз на 1000px");

        //Нажать кнопку Применить
        WebElement ConfirmBtn = driver.findElement(By.xpath(
                "//div[@class='products-page']/div[@class='products-page__content']/div[1]/div[@class='inner-wrapper-sticky']/div[@class='left-filters']//button[@class='button-ui button-ui_brand left-filters__button']"));
        wait.until(ExpectedConditions.elementToBeClickable(ConfirmBtn));
        ConfirmBtn.click();
        logger.info("Фильтр применен");

        //Сортировать
        if (env.equals("firefox")) driver.navigate().refresh();
        WebElement SortedByBtn = driver.findElement(By.xpath(
                "//div[@id='sort-filter']/div[2]//span[.='Сначала недорогие']"));
        wait.until(ExpectedConditions.elementToBeClickable(SortedByBtn));
        action.moveToElement(SortedByBtn).click().build().perform();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebElement SortedByUpperPriceBtn = driver.findElement(By.xpath(
                "/html/body/div[@class='popover-block popover-block_show']/div[@class='top-filter__radio-list ui-radio top-filter__popover']/label[@class='ui-radio__item'][2]/span[@class='ui-radio__content']"));
        wait.until(ExpectedConditions.visibilityOf(SortedByUpperPriceBtn));
        wait.until(ExpectedConditions.elementToBeClickable(SortedByUpperPriceBtn));
        action.moveToElement(SortedByUpperPriceBtn).click().build().perform();
        logger.info("Выполнена сортировка: " + SortedByUpperPriceBtn.getText());

        //Сделать скриншот страницы
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage SortedPageOfPhones = ImageIO.read(file);
            ImageIO.write(SortedPageOfPhones, "png", new File("C:\\Users\\Artyom\\IdeaProjects\\hw1\\screenshots\\SortedPhonesPage.png"));
            logger.info("Скриншот сохранен в файле [C:\\Users\\Artyom\\IdeaProjects\\hw1\\SortedPhonesPage.png]");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Выбрать и перейти на страницу первого продукта в списке
        WebElement firstPhone = driver.findElement(By.cssSelector("" +
                "div:nth-of-type(2) > div:nth-of-type(1) > .catalog-product__name.ui-link.ui-link_black"));
        String linkNewWindow = firstPhone.getAttribute("href");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        driver.get(linkNewWindow);
        logger.info("Открыто новое окно: " + driver.getWindowHandle());

        //Проверить заголовок страницы
        WebElement productCard = driver.findElement(By.cssSelector(
                ".breadcrumb-list__item > span"));
        String productCardName = productCard.getText();
        logger.info("Заголовок страницы: " +driver.getTitle());
        logger.info("Карточка продукта: " + productCardName);
        if (driver.getTitle().contains(productCardName)) logger.info("Заголовок картинки соответствует карточке продукта");
        else logger.info("Заголовок картинки не соответствует карточке продукта");

        //Открыть характеристики
        WebElement Specification = driver.findElement(By.cssSelector("" +
                ".product-card-tabs__list > a:nth-of-type(2)"));
        js.executeScript(script);
        wait.until(ExpectedConditions.elementToBeClickable(Specification));
        action.moveToElement(Specification).click().build().perform();

        //Проверить значение ОП в блоке Характеристики
        try {
            driver.findElement(By.xpath("//*[contains(text(), '8 Гб')]"));
            logger.info("Оперативная память равна 8 Гб");
        } catch (NoSuchElementException e) {
            logger.info("Оперативная память не равна 8 Гб");
        }
    }
}

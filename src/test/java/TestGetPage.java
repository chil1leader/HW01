import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestGetPage {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(TestGetPage.class);
    String env = System.getProperty("browser", "chrome");
    String load = System.getProperty("option", "NORMAL");

    @BeforeEach
    public void setUp() {
        logger.info("env = " + env.toLowerCase());
        logger.info("load strategy = " + load.toUpperCase());
        driver = WebDriverFactory.getDriver(env.toLowerCase(), load.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void openPage() {
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //driver.manage().window().fullscreen();

        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница DNS - " + "https://www.dns-shop.ru/");

        String title = driver.getTitle();
        logger.info("title - " + title.toString());
        String currentUrl = driver.getCurrentUrl();
        logger.info("current URL - " + currentUrl.toString());

        logger.info("Куки:");
        driver.manage().addCookie(new Cookie("Cookie", "This is Cookie"));
        Cookie cookie1 = driver.manage().getCookieNamed("Cookie");
        logger.info(String.format("Domain: %s", cookie1.getDomain()));
        logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
        logger.info(String.format("Name: %s",cookie1.getName()));
        logger.info(String.format("Path: %s",cookie1.getPath()));
        logger.info(String.format("Value: %s",cookie1.getValue()));
        logger.info("--------------------------------------");

        driver.findElement(By.linkText("Да")).click();
        driver.findElement(By.partialLinkText("Быт")).click();

        String query = "//span[contains(@class, 'subcategory__title')]";
        List <WebElement> elements = driver.findElements(By.xpath(query));
        for (WebElement element : elements)
            logger.info("WebElement: " + element.getTagName() + " = " + element.getText());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
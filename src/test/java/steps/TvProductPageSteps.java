package steps;

import helpers.JSExec;
import helpers.ScreenShot;
import helpers.WaitFor;
import models.valueobjects.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.TvProductPage;

import java.util.Date;

public class TvProductPageSteps {
    private static Logger logger = LogManager.getLogger(TvProductPageSteps.class);
    private TvProductPage tvProductPage;

    public TvProductPageSteps(TvProductPage tvProductPage) {
        this.tvProductPage = tvProductPage;
        logger.info("Открыта страница [Продукт. Телевизор]");
        ScreenShot.takeScreenshot(new Date(), "TvProductPage_");
    }


    public String pageTitle() {
        return tvProductPage.getPageTitle();
    }

    public void clickCharacteristicsButton() {
        JSExec.scrollBy(0,800);
        tvProductPage.btnCharacteristicsClick();
        ScreenShot.takeScreenshot(new Date(), "Characteristics_");
    }

    public String getActualCompany() { return tvProductPage.getProductCompany(); }

    public String getActualScreenSize() { return tvProductPage.getProductScreenSize(); }

    public String getActualRefreshRate() { return tvProductPage.getProductRefreshRate(); }

    public String getActualBacklight() { return tvProductPage.getProductBacklight(); }
}

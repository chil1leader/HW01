package steps;

import helpers.JSExec;
import helpers.ScreenShot;
import helpers.WaitFor;
import models.valueobjects.Company;
import models.valueobjects.RefreshRate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pages.TvPageWithElements;

import java.util.Date;

public class TvPageSteps {
    private static Logger logger = LogManager.getLogger(TvPageSteps.class);
    private TvPageWithElements tvPage;

    public TvPageSteps(TvPageWithElements tvPage) {
        this.tvPage = tvPage;
        logger.info("Открыта страница [Телевизоры]");
        ScreenShot.takeScreenshot(new Date(), "TvPage_");
    }

    public void orderByExpensiveFirst() {
        tvPage.accordeonSortClick();
        tvPage.rbtnExpensiveClick();
        ScreenShot.takeScreenshot(new Date(), "TvPageAfterSorting_");
    }

    public void filterByCompany(Company company) {
        JSExec.scrollBy(0, 1200);
        tvPage.chbxCompanyClick(company.getCompany());
    }

    public void filterScreenSize(int minSize, int maxSize) {
        JSExec.scrollBy(0, 500);
        tvPage.accordeonSizeScreenClick();
        tvPage.txtbxSizeScreenSetValue(minSize, maxSize);
    }

    public void filterByRefreshRate(RefreshRate rate) {
        JSExec.scrollBy(0, 500);
        tvPage.accordeonRefreshRateClick();
        tvPage.chbxRefreshRateClick(rate.getRate());
    }

    public void filterByBacklight(String backlight) {
        JSExec.scrollBy(0, 500);
        tvPage.accordeonBacklightClick();
        tvPage.chbxBacklightClick(backlight);
    }

    public void clickButtonApply() {
        JSExec.scrollBy(0, 500);
        tvPage.btnApplyClick();
    }

    public void clickLinkFirstProduct(String product) {
        JSExec.scrollBy(0, -500);
        tvPage.linkFirstProductClick(product);
    }

}

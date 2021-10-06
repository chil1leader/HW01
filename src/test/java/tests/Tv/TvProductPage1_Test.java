package tests.Tv;

import helpers.ScreenShot;
import models.Tv;
import models.TvBuilder;
import models.valueobjects.Company;
import models.valueobjects.RefreshRate;
import org.junit.jupiter.api.Test;
import pages.StartPageWithElements;
import pages.TvPageWithElements;
import pages.TvProductPage;
import steps.StartPageSteps;
import steps.TvPageSteps;
import steps.TvProductPageSteps;
import tests.BaseTest;

import java.time.Duration;

public class TvProductPage1_Test extends BaseTest {

    @Test
    public void selectedProduct_Is_Samsung_QE75Q950TSUXRU() {
        TvBuilder builder = new TvBuilder(
                new Company("Samsung"),
                new RefreshRate("120"))
                .setMinSize(60)
                .setMaxSize(80)
                .setBacklight("Direct LED");
        Tv tv = builder.build();

        TvProductPageSteps tvProductPageSteps = getProductPage(tv);

        String expected = "Купить 75\" (189 см) Телевизор LED Samsung QE75Q950TSUXRU серый в интернет магазине DNS. Характеристики, цена Samsung QE75Q950TSUXRU | 8165296";
        TvProductPageAssert smartphoneProductAssert = new TvProductPageAssert(tvProductPageSteps);
        smartphoneProductAssert.pageTitleEquals(expected);

    }

    @Test
    public void selectedProduct_Matched_Filters() {
        TvBuilder builder = new TvBuilder(
                new Company("Samsung"),
                new RefreshRate("120"))
                .setMinSize(60)
                .setMaxSize(80)
                .setBacklight("Direct LED");
        Tv tv = builder.build();

        TvProductPageSteps tvProductPageSteps = getProductPage(tv);

        TvProductPageAssert tvProductAssert = new TvProductPageAssert(tvProductPageSteps);
        tvProductAssert.characteristicsEquals(tv);

    }

    public TvProductPageSteps getProductPage(Tv tv) {
        driver.get("https://www.dns-shop.ru/");
        StartPageSteps startPageSteps = new StartPageSteps(new StartPageWithElements(driver));
        startPageSteps.clickLinkSmarts();

        TvPageSteps tvPageSteps = new TvPageSteps(new TvPageWithElements(driver));
        tvPageSteps.filterByCompany(tv.getCompany());
        tvPageSteps.filterScreenSize(tv.getMinSize(), tv.getMaxSize());
        tvPageSteps.filterByRefreshRate(tv.getRate());
        tvPageSteps.filterByBacklight(tv.getBacklight());
        tvPageSteps.clickButtonApply();
        tvPageSteps.orderByExpensiveFirst();
        tvPageSteps.clickLinkFirstProduct("Телевизор LED Samsung QE75Q950TSUXRU серый");
        return new TvProductPageSteps(new TvProductPage(driver));
    }
}

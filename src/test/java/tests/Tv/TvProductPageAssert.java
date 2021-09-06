package tests.Tv;

import org.junit.jupiter.api.Assertions;
import steps.TvProductPageSteps;


public class TvProductPageAssert {

    TvProductPageSteps tvProductPageSteps;

    public TvProductPageAssert(TvProductPageSteps tvProductPageSteps) {
        this.tvProductPageSteps = tvProductPageSteps;
    }

    public void pageTitleEquals(String expected) {
        String actual = tvProductPageSteps.pageTitle();
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
        
    }

    public void companyEquals(String expected) {

        String actual = tvProductPageSteps.getActualCompany();
        Assertions.assertTrue(actual.contains(expected), "Ошибка! Актуальная компания не соответствует фильтрации");
    }

    public void screenSizeEquals(int expectedMin, int expectedMax) {

        int actual = Integer.parseInt(tvProductPageSteps.getActualScreenSize().replaceAll("\\D+",""));
        Assertions.assertTrue(actual >= expectedMin & actual <= expectedMax, "Ошибка! Актуальная диагональ не соответствует фильтрации");
    }

    public void refreshRateEquals(String expectedRefreshRate){
        int actual = Integer.parseInt(tvProductPageSteps.getActualRefreshRate().replaceAll("\\D+",""));
        Assertions.assertEquals(Integer.parseInt(expectedRefreshRate), actual, "Ошибка! Актуальная частота обновления экрана не соответствует фильтрации");
    }

    public void backlightEquals(String expectedBacklight) {
        String actual = tvProductPageSteps.getActualBacklight();
        Assertions.assertTrue(actual.contains(expectedBacklight), "Ошибка! Актуальная компания не соответствует фильтрации");
    }
 }

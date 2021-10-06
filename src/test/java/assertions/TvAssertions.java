package assertions;

import models.testobjetcs.Tv;
import org.junit.jupiter.api.Assertions;
import web.pages.TvProductPage;

public class TvAssertions {
    TvProductPage tvProductPage;

    public TvAssertions(TvProductPage tvProductPage) {
        this.tvProductPage = tvProductPage;
    }
    public void companyEquals(String company) {
        Assertions.assertTrue(tvProductPage.tableCharacteristics().getDataValue("Модель").contains(company));
    }
    public void screenSizeEquals(int expectedMin, int expectedMax) {
        int actual = Integer.parseInt(tvProductPage.tableCharacteristics().getDataValue("Диагональ экрана (дюйм)").replaceAll("\\D+",""));
        Assertions.assertTrue(actual >= expectedMin & actual <= expectedMax, "Ошибка! Актуальная диагональ не соответствует фильтрации");
    }

    public void refreshRateEquals(String rate) {
        int actual = Integer.parseInt(tvProductPage.tableCharacteristics().getDataValue("Частота обновления экрана").replaceAll("\\D+",""));
        Assertions.assertEquals(Integer.parseInt(rate), actual);
    }

    public void backlightEquals(String backlight) {
        Assertions.assertTrue(tvProductPage.tableCharacteristics().getDataValue("Тип подсветки").contains(backlight));
    }

    public void characteristicsEquals(Tv tv) {
        this.companyEquals(tv.getCompany().getCompany());
        this.screenSizeEquals(tv.getMinSize(), tv.getMaxSize());
        this.refreshRateEquals(tv.getRate().getRate());
        this.backlightEquals(tv.getBacklight());
    }
}

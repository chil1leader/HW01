package steps;

import assertions.TvAssertions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.*;
import models.builders.TvBuilder;
import models.testobjetcs.Tv;
import models.valueobjects.Company;
import models.valueobjects.RefreshRate;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.Assertions;
import web.drivers.*;
import web.helpers.JavaScriptHelper;
import web.pages.*;

import java.util.List;
import java.util.Map;

public class TvSteps {
    private Logger logger = LogManager.getLogger(TvSteps.class);

    // Страницы
    StartPage startPage;
    TvsPage tvsPage;
    TvProductPage tvProductPage;
    Tv tv = new Tv();

    @Дано("Открыта Главная страница ДНС")
    public void startDriverAndOpenStartPage() {
        startPage = new StartPage(WebDriverFactory.getCurrentDriver());
        tvsPage = new TvsPage(WebDriverFactory.getCurrentDriver());
        tvProductPage = new TvProductPage(WebDriverFactory.getCurrentDriver());
        // Открыть страницу https://www.dns-shop.ru/
        WebDriverFactory.getCurrentDriver().get("https://www.dns-shop.ru/");
        logger.info("Открыта Стартовая страница сайта DNS");
    }

    @Когда("Выполнен переход на страницу Телевизоры")
    public void openSmartphonesPage() {
        startPage.linkYes().click();
        startPage.linkTvAndMultimedia().focusOnLink();
        startPage.linkTvs().click();
        logger.info("Выполнен переход на страницу Телевизоры");
    }

    @Тогда("Проверить: В заголовке страницы отображается текст Смартфоны")
    public void assertTitle() {
        // Проверка заголовка страницы
        logger.info("Проверка заголовка страницы");
        Assertions.assertTrue(tvsPage.getPageTitle().contains("Телевизоры"), "В заголовке страницы не отображается текст Смартфоны");
    }

    @И("В фильтре {string} выбрано значение {string}")
    public void setFilterBy(String filterBy, String value) {
        JavaScriptHelper.scrollBy(0, 600);
        switch (filterBy) {
            case "Производитель":
                tvsPage.fullDivCompany().click();
                tvsPage.chbxCompany(value).setChecked(true);
                tv.setCompany(new Company(value));
                break;
            case "Диагональ экрана":
                tvsPage.accordeonSizeScreen().show();
                tvsPage.txtbxMinSize().setValue(value.substring(0, 2));
                tvsPage.txtbxMaxSize().setValue(value.substring(value.length() - 2));
                tv.setMinSize(Integer.parseInt(value.substring(0, 2)));
                tv.setMaxSize(Integer.parseInt(value.substring(value.length() - 2)));
                break;
            case "Тип подсветки":
                tvsPage.accordeonBacklight().show();
                tvsPage.chbxBacklight(value).setChecked(true);
                tv.setBacklight(value);
                break;
            case "Частота обновления":
                tvsPage.accordeonRefreshRate().show();
                tvsPage.chbxRefreshRate(value).setChecked(true);
                tv.setRate(new RefreshRate(value));
                break;
        }
        logger.info("В фильтре " + filterBy + " выбрано значение " + value);
    }

    @И("Применены выбранные фильтры")
    public void applyFilters() {
        JavaScriptHelper.scrollBy(0, 400);
        tvsPage.buttonApply().click();
        logger.info("Применены выбранные фильтры");
    }

    @И("Установлена сортировка {string}")
    public void setSortBy(String sortBy) {
        tvsPage.accordeonSort().show();
        tvsPage.radioButtonSort(sortBy).setSelected(true);
        logger.info("Сортировка " + sortBy);
    }

    @И("Выполнен переход на страницу первого товара из списка")
    public void selectFirstSmartphone() {
        JavaScriptHelper.scrollBy(0, -600);
        tvsPage.linkFirstProduct().openInNewWindow();
        logger.info("Выполнен переход на страницу первого товара из списка");
    }

    @Когда("Открыты характеристики")
    public void openCharacteristics() {
        JavaScriptHelper.scrollBy(0, 700);
        tvProductPage.characteristicsLink().click();
    }

    @Тогда("Проверка характеристик")
    public void assertCharacteristics() {
        TvAssertions tvAssertions = new TvAssertions(tvProductPage);
        tvAssertions.characteristicsEquals(tv);
    }


    @И("Установлены фильтры из таблицы с одной колонкой")
    public void setFiltersFromTableWithOneColumn(List<String> filters) {
        TvBuilder builder = new TvBuilder(
                new Company(filters.get(0)),
                new RefreshRate(filters.get(2)))
                .setMinSize(Integer.parseInt(filters.get(1).substring(0, 2)))
                .setMaxSize(Integer.parseInt(filters.get(1).substring(filters.get(1).length() - 2)))
                .setBacklight(filters.get(3));
        tv = builder.build();
        JavaScriptHelper.scrollBy(0, 600);

        tvsPage.fullDivCompany().click();
        tvsPage.chbxCompany(tv.getCompany().getCompany()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);

        tvsPage.accordeonSizeScreen().show();
        tvsPage.txtbxMaxSize().setValue(String.valueOf(tv.getMinSize()));
        tvsPage.txtbxMinSize().setValue(String.valueOf(tv.getMaxSize()));
        JavaScriptHelper.scrollBy(0, 400);

        tvsPage.accordeonRefreshRate().show();
        tvsPage.chbxRefreshRate(tv.getRate().getRate()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);

        tvsPage.accordeonBacklight().show();
        tvsPage.chbxBacklight(tv.getBacklight()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);

        logger.info("***** Установлены фильтры из таблицы с одной колонкой");

    }

    @И("Установлены фильтры из таблицы с двумя колонками")
    public void setFiltersFromTableWithTwoColumns(Map<String, String> filters) {
        TvBuilder builder = new TvBuilder(
                new Company(filters.get("Company")),
                new RefreshRate(filters.get("Refresh Rate")))
                .setMinSize(Integer.parseInt(filters.get("Screen Size").substring(0, 2)))
                .setMaxSize(Integer.parseInt(filters.get("Screen Size").substring(filters.get("Screen Size").length() - 2)))
                .setBacklight(filters.get("Backlight"));
        tv = builder.build();
        JavaScriptHelper.scrollBy(0, 600);

        tvsPage.chbxCompany(tv.getCompany().getCompany()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);

        tvsPage.accordeonSizeScreen().show();
        tvsPage.txtbxMaxSize().setValue(String.valueOf(tv.getMinSize()));
        tvsPage.txtbxMinSize().setValue(String.valueOf(tv.getMaxSize()));
        JavaScriptHelper.scrollBy(0, 400);

        tvsPage.accordeonRefreshRate().show();
        tvsPage.chbxRefreshRate(tv.getRate().getRate()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);

        tvsPage.accordeonBacklight().show();
        tvsPage.chbxBacklight(tv.getBacklight()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);

        logger.info("***** Установлены фильтры из таблицы с двумя колонками");
    }

    @Дано("Установлена сортировка и фильтры из таблицы с тремя колонками")
    public void setFiltersAndSortFromTableWithFiveColumns(DataTable dataTable) {
        List <Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        String sortBy = table.get(0).get("Sort");
        String filterByCompany = table.get(0).get("Company");
        String filterByScreenSize = table.get(0).get("Screen Size");
        String filterByRefreshRate = table.get(0).get("Refresh Rate");
        String filterByBacklight = table.get(0).get("Backlight");

        tvsPage.accordeonSort().show();
        tvsPage.radioButtonSort(sortBy).setSelected(true);

        TvBuilder builder = new TvBuilder(
                new Company(filterByCompany),
                new RefreshRate(filterByRefreshRate))
                .setMinSize(Integer.parseInt(filterByScreenSize.substring(0, 2)))
                .setMaxSize(Integer.parseInt(filterByScreenSize.substring(filterByScreenSize.length() - 2)))
                .setBacklight(filterByBacklight);
        tv = builder.build();
        JavaScriptHelper.scrollBy(0, 600);

        tvsPage.chbxCompany(tv.getCompany().getCompany()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);

        tvsPage.accordeonSizeScreen().show();
        tvsPage.txtbxMaxSize().setValue(String.valueOf(tv.getMinSize()));
        tvsPage.txtbxMinSize().setValue(String.valueOf(tv.getMaxSize()));
        JavaScriptHelper.scrollBy(0, 400);

        tvsPage.accordeonRefreshRate().show();
        tvsPage.chbxRefreshRate(tv.getRate().getRate()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);

        tvsPage.accordeonBacklight().show();
        tvsPage.chbxBacklight(tv.getBacklight()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);

        logger.info("***** Установлены фильтры из таблицы с двумя колонками");


    }

    @Тогда("Проверить: В заголовке страницы отображается текст {string}")
    public void assertTitleSmartphoneProduct(String company) {
        logger.info("Проверка заголовка страницы");
        Assertions.assertTrue(tvProductPage.getPageTitle().contains(company), "В заголовке страницы не отображается текст " + company);
    }


}
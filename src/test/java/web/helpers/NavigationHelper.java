package web.helpers;

import org.apache.logging.log4j.*;
import web.drivers.WebDriverFactory;

public class NavigationHelper {

    private static Logger logger = LogManager.getLogger(NavigationHelper.class);

    public static void navigateTo(String URL) {
        WebDriverFactory.getCurrentDriver().navigate().to(URL);
    }

    public static void back() {
        WebDriverFactory.getCurrentDriver().navigate().back();
    }

    public static void forward() {
        WebDriverFactory.getCurrentDriver().navigate().forward();
    }

    public static void refresh() {
        WebDriverFactory.getCurrentDriver().navigate().refresh();
    }
}

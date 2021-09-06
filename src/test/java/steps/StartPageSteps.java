package steps;

import helpers.ScreenShot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.StartPageWithElements;

public class StartPageSteps {

    private static Logger logger = LogManager.getLogger(StartPageSteps.class);
    private StartPageWithElements startPage;

    public StartPageSteps(StartPageWithElements startPage) {
        this.startPage = startPage;
        logger.info("Открыта страница [Стартовая страница DNS]");
    }

    public void clickLinkSmarts() {
        startPage.linkTvAndMultimediaMove();
        startPage.linkTVClick();
    }
}

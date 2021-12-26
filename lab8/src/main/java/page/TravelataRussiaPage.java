package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class TravelataRussiaPage extends AbstractPage{
    private static final String RUSSIAPAGE_URL = "https://travelata.ru/russia";
    private static final String DIRECTION_SELECTOR = ".cityPreview";
    private static final String DIRECTION_NAME_SELECTOR = ".h3";
    private static final String TYPE_SELECTOR = ".js-tourFilter__item > .icon.icon-rtype_i16_ski";
    private static final String TYPE_NAME_SELECTOR = ".js-tourFilter__item > .icon.icon-rtype_i16_ski + span";
    private static final String DISPLAYED_TYPE_NAME_SELECTOR = ".js-selected-rest-type-label";

    private final Logger logger = LogManager.getRootLogger();

    public TravelataRussiaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TravelataRussiaPage openPage() {
        logger.info("open 'rest in russia' page");
        driver.get(RUSSIAPAGE_URL);
        return this;
    }

    public String getChoosenTypeName() {
        logger.info("get name of choosen type of tour");
        return Wait.elementToBeClickableWaitBySelector(driver, TYPE_NAME_SELECTOR).getText();
    }

    public String getDisplayedOnAPageTypeName() {
        logger.info("get type name that displayed on a page");
        return Wait.elementToBeClickableWaitBySelector(driver, DISPLAYED_TYPE_NAME_SELECTOR).getText();
    }

    public TravelataRussiaPage chooseType() {
        logger.info("click on a particular type");
        Wait.presenceOfElementLocatedWaitBySelector(driver, TYPE_SELECTOR).click();
        return this;
    }

}

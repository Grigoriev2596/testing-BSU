package page;

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

    public TravelataRussiaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TravelataRussiaPage openPage() {
        driver.get(RUSSIAPAGE_URL);
        return this;
    }

    public String getChoosenTypeName() {
        return Wait.elementToBeClickableWaitBySelector(driver, TYPE_NAME_SELECTOR).getText();
    }

    public String getDisplayedOnAPageTypeName() {
        return Wait.elementToBeClickableWaitBySelector(driver, DISPLAYED_TYPE_NAME_SELECTOR).getText();
    }

    public TravelataRussiaPage chooseType() {
        Wait.presenceOfElementLocatedWaitBySelector(driver, TYPE_SELECTOR).click();
        return this;
    }

    public String getDirectionName() {
        return Wait.presenceOfElementLocatedWaitBySelector(driver, DIRECTION_NAME_SELECTOR).getText();
    }


}

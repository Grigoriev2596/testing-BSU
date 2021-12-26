package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

import java.util.List;
import java.util.stream.Collectors;

public class TravelataHolidayPage extends AbstractPage{

    private static final String HOLIDAY_PAGE_URL = "https://travelata.ru/tury-na-majskie-prazdniki";
    private static final String HOLIDAY_DIRECTION_NAME_SELECTOR = ".h3";
    private static final String HOLIDAY_DIRECTION_SELECTOR = ".cityPreview.js-city-preview";

    public TravelataHolidayPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TravelataHolidayPage openPage() {
        driver.get(HOLIDAY_PAGE_URL);
        return this;
    }

    public TravelataSearchPage chooseHolidayDirection() {
        Wait.presenceOfElementLocatedWaitBySelector(driver, HOLIDAY_DIRECTION_SELECTOR).click();
        return new TravelataSearchPage(driver);
    }

    public String getHolidayDirectionName() {
        return Wait.presenceOfElementLocatedWaitBySelector(driver, HOLIDAY_DIRECTION_NAME_SELECTOR).getText().trim();
    }



}

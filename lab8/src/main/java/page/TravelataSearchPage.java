package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Wait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class TravelataSearchPage extends AbstractPage{
    private static final String SEARCHPAGE_URL = "https://travelata.ru/search";
    private static final String TOUR_INFORMATION_CARD_SELECTOR = ".serpHotelCard__criteria";
    private static final String TOUR_SEA_LINE_INFORMATION_XPATH = "//div[contains(i/following-sibling::text(), \"3-я линия\")]";
    private static final String THIRD_SEA_LINE_CHECKBOX_SELECTOR = ".thirdLine > .checkbox > .checkboxStyle";
    private static final String BEST_RATING_HOTEL_CHECKBOX_SELECTOR = ".best > .filtersList__item > label";
    private static final String ACTUAL_HOTELS_RATING_SELECTOR = ".serpHotelCard__tip.serpHotelCard__rating";
    private static final String TOUR_DIRECTION_NAME_SELECTOR = ".serpHotelCard__resort.goToHotel.distance";

    public TravelataSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TravelataSearchPage openPage() {
        logger.info("open search page");
        driver.get(SEARCHPAGE_URL);
        return this;
    }

    public TravelataSearchPage chooseSeaLine() {
        logger.info("choose sea line");
        Wait.elementToBeClickableWaitBySelector(driver, THIRD_SEA_LINE_CHECKBOX_SELECTOR).click();
        return this;
    }

    public TravelataSearchPage chooseBestRatingHotelsCheckbox() {
        logger.info("choose hotel rating");
        Wait.elementToBeClickableWaitBySelector(driver, BEST_RATING_HOTEL_CHECKBOX_SELECTOR).click();
        return this;
    }


    public List<String> getTourInformationCards() {
        logger.info("get information about tour including amount of tourist");

        Wait.presenceOfElementLocatedWaitBySelector(driver, TOUR_INFORMATION_CARD_SELECTOR, 20);
        return driver.findElements(By.cssSelector(TOUR_INFORMATION_CARD_SELECTOR)).stream()
                .map((webEl) -> webEl.getText())
                .collect(Collectors.toList());
    }


    public List<String> getTourSeaLineInformation() {
        logger.info("get information about sea line of displayed tours");
        Wait.presenceOfElementLocatedWaitByXpath(driver,TOUR_SEA_LINE_INFORMATION_XPATH, 20);
        return driver.findElements(By.xpath(TOUR_SEA_LINE_INFORMATION_XPATH)).stream()
                .map((webEl) -> webEl.getText())
                .collect(Collectors.toList());
    }

    public List<Double> getHotelRatingInformation() {
        logger.info("get information about hotel rating of displayed tours");
        Wait.presenceOfElementLocatedWaitBySelector(driver, ACTUAL_HOTELS_RATING_SELECTOR, 20);
        return driver.findElements(By.cssSelector(ACTUAL_HOTELS_RATING_SELECTOR)).stream()
                .map((webEl) -> Double.valueOf(webEl.getText().replace(" ", "")))
                .collect(Collectors.toList());
    }

    public List<String> getTourDirectionInformation() {
        logger.info("get information about direction of the tours");
        Wait.presenceOfElementLocatedWaitBySelector(driver, TOUR_DIRECTION_NAME_SELECTOR, 20);
        return driver.findElements(By.cssSelector(TOUR_DIRECTION_NAME_SELECTOR)).stream()
                .map((webEl) -> webEl.getText().trim())
                .collect(Collectors.toList());
    }

}

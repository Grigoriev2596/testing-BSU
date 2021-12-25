package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TravelataHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://travelata.ru";
    private int touristAmount = 1;
    private final Logger logger = LogManager.getRootLogger();

    private static final String DROP_DOWN_TOURIST_CONTROL_FORM_X_PATH = "//div[contains(@class, 'formDropdown touristGroup')]";
    private static final String TOURIST_AMOUNT_BUTTON_X_PATH = "//div[contains(@class, 'adults__buttonset')]/label[contains(text(),'%d')]";
    private static final String SEARCH_BUTTON_x_PATH = "//*[@id=\"startSearch\"]";
    private static final String CLOSE_DISCOUNT_NEW_YEAR_WINDOW_BUTTON = "//div[contains(@class, 'js-lottery-dg ypopup ui-dialog-content ui-widget-content')]/div[contains(@class, 'popupClose')]";


    public TravelataHomePage(WebDriver driver, int touristAmount) {
        super(driver);
        this.touristAmount = touristAmount;
        logger.info("открываю домашнюю страницу");
        PageFactory.initElements(driver, this);
    }

    public TravelataHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public TravelataHomePage closeNewYearDiscountWindow() {
        findAndClickOnWebElement(CLOSE_DISCOUNT_NEW_YEAR_WINDOW_BUTTON);
        return this;
    }


    public TravelataHomePage openDropDownTouristControlForm() {
        findAndClickOnWebElement(DROP_DOWN_TOURIST_CONTROL_FORM_X_PATH);
        return this;
    }

    public TravelataHomePage selectTouristAmount() {
        String touristAmountButtonXPath = String.format(TOURIST_AMOUNT_BUTTON_X_PATH, touristAmount);
        findAndClickOnWebElement(touristAmountButtonXPath);
        return this;
    }

    public TravelataSearchResultPage search() {
        findAndClickOnWebElement(SEARCH_BUTTON_x_PATH);
        return new TravelataSearchResultPage(driver);
    }
    public void findAndClickOnWebElement(String xpath) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
    }
}

package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class TravelataHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://travelata.ru";
    private final Logger logger = LogManager.getRootLogger();

    private static final String DROP_DOWN_TOURIST_CONTROL_FORM_SELECTOR = ".formDropdown.touristGroup";
    private static final String TOURIST_AMOUNT_BUTTON_SELECTOR = "[for='adults__buttonset_view139%d']";
    private static final String SEARCH_BUTTON_SELECTOR = "#startSearch";
    private static final String OPEN_LOGIN_WINDOW_BUTTON_SELECTOR = ".accountTopMenuBar__logInButton";
    private static final String EMAIL_INPUT_SELECTOR = "#accountAuthorize__email";
    private static final String PASSWORD_INPUT_SELECTOR = "#accountAuthorize__password";
    private static final String SUBMIT_LOGIN_BUTTON_SELECTOR = ".accountAuthorize__submitAuthForm";
    private static final String LOGIN_ERROR_SELECTOR = "#accountAuthorize__email-error";
    private static final String MAILING_INPUT_SELECTOR = "[name='email']";
    private static final String MAILING_SUCCESS_MESSAGE_SELECTOR = ".success-block__title";
    private static final String OPEN_DROPDOWN_CITIES_LIST_BUTTON_SELECTOR = ".region";
    private static final String CHOOSE_CITY_BUTTON_SELECTOR = "[title='Омск']";
    private static final String CURRENT_CITY_VALUE_SELECTOR = "[title='Омск'] > span";



    public TravelataHomePage(WebDriver driver) {
        super(driver);
        logger.info("open home page");
        PageFactory.initElements(driver, this);
    }

    public TravelataHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public TravelataHomePage openDropDownCitiesList() {
        Wait.presenceOfElementLocatedWaitBySelector(driver, OPEN_DROPDOWN_CITIES_LIST_BUTTON_SELECTOR).click();
        return this;
    }

    public TravelataHomePage chooseCity() {
        Wait.presenceOfElementLocatedWaitBySelector(driver, CHOOSE_CITY_BUTTON_SELECTOR);
        return this;
    }

    public String getCurrentCityValue() {
        return Wait.presenceOfElementLocatedWaitBySelector(driver,CURRENT_CITY_VALUE_SELECTOR).getText();
    }

    public TravelataHomePage openDropDownTouristControlForm() {
        Wait.elementToBeClickableWaitBySelector(driver,DROP_DOWN_TOURIST_CONTROL_FORM_SELECTOR).click();
        return this;
    }

    public TravelataHomePage selectTouristAmount(int touristAmount) {
        String touristAmountButtonSelector = String.format(TOURIST_AMOUNT_BUTTON_SELECTOR, touristAmount);
        Wait.presenceOfElementLocatedWaitBySelector(driver ,touristAmountButtonSelector).click();
        return this;
    }

    public TravelataSearchPage search() {
        Wait.presenceOfElementLocatedWaitBySelector(driver, SEARCH_BUTTON_SELECTOR).click();
        return new TravelataSearchPage(driver);
    }

    public TravelataHomePage openTravelataLoginWindow() {
        Wait.presenceOfElementLocatedWaitBySelector(driver, OPEN_LOGIN_WINDOW_BUTTON_SELECTOR).click();
        return this;
    }

    public TravelataHomePage inputEmailAndPasswordToLoginFormAndSubmit(User user) {
        Wait.presenceOfElementLocatedWaitBySelector( driver ,EMAIL_INPUT_SELECTOR).sendKeys(user.getMail());
        Wait.presenceOfElementLocatedWaitBySelector( driver ,PASSWORD_INPUT_SELECTOR).sendKeys(user.getPassword());
        Wait.presenceOfElementLocatedWaitBySelector(driver, SUBMIT_LOGIN_BUTTON_SELECTOR).click();
        return this;
    }

    public TravelataHomePage inputEmailToMailingInputAndSubmit(String email) {
        Wait.presenceOfElementLocatedWaitBySelector(driver, MAILING_INPUT_SELECTOR).sendKeys(email);
        Wait.presenceOfElementLocatedWaitBySelector(driver, MAILING_INPUT_SELECTOR).sendKeys(Keys.ENTER);
        return this;
    }

    public String getMailingSuccesfulMessage() {
        return Wait.elementToBeClickableWaitBySelector(driver, MAILING_SUCCESS_MESSAGE_SELECTOR).getText();
    }

    public String getLoginErrorText() {
        return Wait.elementToBeClickableWaitBySelector(driver, LOGIN_ERROR_SELECTOR).getText();
    }


}

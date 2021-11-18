package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TravelataHomePage {
    private static final String HOMEPAGE_URL = "https://travelata.ru";
    private  int touristAmount;
    private WebDriver driver;


    private static final String DROP_DOWN_TOURIST_CONTROL_FORM_X_PATH = "/html/body/section/div/div[1]/div[2]/div/div[1]/form/div[5]/div";
    private static final String TOURIST_AMOUNT_BUTTON_X_PATH = "//*[@id=\"mainSearchForm\"]/div[5]/div/div[2]/div/div/div[2]/div/label[%s]";
    private static final String SEARCH_BUTTON_x_PATH = "//*[@id=\"startSearch\"]";

    public TravelataHomePage(WebDriver driver, int touristAmount) {
        this.touristAmount = touristAmount;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TravelataHomePage openPage() {
        driver.get(HOMEPAGE_URL);
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
        return new TravelataSearchResultPage(driver, touristAmount);
    }
    public void findAndClickOnWebElement(String xpath) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
    }

}

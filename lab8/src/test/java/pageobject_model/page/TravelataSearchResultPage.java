package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TravelataSearchResultPage {

    private WebDriver driver;
    private int touristAmount;

    @FindBy(className = "serpHotelCard__criteria")
    private List<WebElement> tourInformationCards;
    private static final String TOUR_INFORMATION_CARD_CLASSNAME = "serpHotelCard__criteria";

    public TravelataSearchResultPage(WebDriver driver, int touristAmount) {
        this.driver = driver;
        this.touristAmount = touristAmount;
    }

    public boolean ifAllTourAreSuitsForTouristAmount() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className(TOUR_INFORMATION_CARD_CLASSNAME)));
        List<WebElement> tourInformationCards = driver.findElements(By.className(TOUR_INFORMATION_CARD_CLASSNAME));

        for(WebElement card : tourInformationCards) {
            if (!card.getText().contains(touristAmount + " взрослы")) {
                return false;
            }
        }
        return true;
    }


}

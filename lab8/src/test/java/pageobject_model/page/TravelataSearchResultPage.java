package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getTourInformationCards() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.className(TOUR_INFORMATION_CARD_CLASSNAME)));
        return driver.findElements(By.className(TOUR_INFORMATION_CARD_CLASSNAME)).stream()
                .map((webEl) -> webEl.getText())
                .collect(Collectors.toList());
    }


}

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class TravelataSearchResultPage extends AbstractPage{

    private static final String TOUR_INFORMATION_CARD_CLASSNAME = "serpHotelCard__criteria";
    private static final String CLOSE_DISCOUNT_WINDOW_BUTTON = "//button[contains(@data-fl-close, \"1800\")]";

    public TravelataSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public TravelataSearchResultPage closeAnotherDiscountWindow() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE_DISCOUNT_WINDOW_BUTTON))).click();
        return this;
    }

    public List<String> getTourInformationCards() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.className(TOUR_INFORMATION_CARD_CLASSNAME)));
        return driver.findElements(By.className(TOUR_INFORMATION_CARD_CLASSNAME)).stream()
                .map((webEl) -> webEl.getText())
                .collect(Collectors.toList());
    }
}

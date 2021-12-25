import page.TravelataHomePage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebDriverTravelataTest extends CommonConditions{

    private final static int TOURIST_AMOUNT = 1;

    private final static String ADULT_KEYWORD_WITHOUT_ENDING = "взрослы";

    @Test
    public void SearchResultSuitsForParticularAmountOfTourists() throws InterruptedException {

        List<String> tourInformationCards = new TravelataHomePage(driver, TOURIST_AMOUNT)
                .openPage()
                //.closeNewYearDiscountWindow()
                .openDropDownTouristControlForm()
                .selectTouristAmount()
                .search()
                //.closeAnotherDiscountWindow()
                .getTourInformationCards();
        Assertions.assertThat(tourInformationCards).allSatisfy(text -> Assertions.assertThat(text).contains(TOURIST_AMOUNT + " " + ADULT_KEYWORD_WITHOUT_ENDING));
    }
}

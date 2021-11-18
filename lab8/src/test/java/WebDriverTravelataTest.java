import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.TravelataHomePage;

import java.util.List;

public class WebDriverTravelataTest {

    private WebDriver driver;

    private final static int TOURIST_AMOUNT = 4;

    private final static String ADULT_KEYWORD_WITHOUT_ENDING = "взрослы";

    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }


    @Test
    public void SearchResultSuitsForParticularAmountOfTourists() throws InterruptedException {

        List<String> tourInformationCards = new TravelataHomePage(driver, TOURIST_AMOUNT)
                .openPage()
                .openDropDownTouristControlForm()
                .selectTouristAmount()
                .search()
                .getTourInformationCards();

        Assertions.assertThat(tourInformationCards).filteredOn(text -> text.contains(TOURIST_AMOUNT + " " + ADULT_KEYWORD_WITHOUT_ENDING));
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

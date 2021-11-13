import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.TravelataHomePage;

import java.time.Duration;
import java.util.List;

public class WebDriverTravelataTest {

    private WebDriver driver;

    private final static int TOURIST_AMOUNT = 4;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        driver = new ChromeDriver(options);
    }


    @Test
    public void SearchResultSuitsForParticularAmountOfTourists() throws InterruptedException {

        boolean expected = new TravelataHomePage(driver, TOURIST_AMOUNT)
                .openPage()
                .openDropDownTouristControlForm()
                .selectTouristAmount()
                .search()
                .ifAllTourAreSuitsForTouristAmount();

        Assert.assertTrue(expected, "Tours are not suitable for four people");
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

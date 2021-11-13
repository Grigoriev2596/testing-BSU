import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelloWebDriver {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://travelata.ru/search");



        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mainSearchForm\"]/div[5]/div/div[1]/div"))).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mainSearchForm\"]/div[5]/div/div[2]/div/div/div[2]/div/label[4]"))).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/section/div/div[2]/form/div[6]/div"))).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("serpHotelCard__criteria")));
        List<WebElement> tourInformationCards = driver.findElements(By.className("serpHotelCard__criteria"));

        boolean isTourForFourPeople = true;

        for(WebElement card : tourInformationCards) {
            if (!card.getText().contains("4 взрослых")) {
                isTourForFourPeople = false;
                break;
            }
        }
        System.out.println(isTourForFourPeople);
        Thread.sleep(10000);
        driver.quit();
    }
}

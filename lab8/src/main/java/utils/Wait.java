package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    public static WebElement presenceOfElementLocatedWaitByXpath(WebDriver driver, String xpath, int timeOut) {
        return new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
    public static WebElement presenceOfElementLocatedWaitByXpath(WebDriver driver, String xpath) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static WebElement presenceOfElementLocatedWaitBySelector(WebDriver driver, String selector, int timeOut) {
        return new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }

    public static WebElement presenceOfElementLocatedWaitBySelector(WebDriver driver, String selector) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }

    public static WebElement elementToBeClickableWaitBySelector(WebDriver driver, String selector, int timeOut) {
        return new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
    }

    public static WebElement elementToBeClickableWaitBySelector(WebDriver driver, String selector) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
    }

    public static WebElement elementToBeClickableWaitByxpath(WebDriver driver, String xpath) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
}

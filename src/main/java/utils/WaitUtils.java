package utils;

import config.WebConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait wait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(WebConfig.TIMEOUT));
    }

    public static WebElement waitForVisible(WebDriver driver, By locator) {
        return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForClickable(WebDriver driver, By locator) {
        wait(driver).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForUrlContains(WebDriver driver, String value) {
        wait(driver).until(ExpectedConditions.urlContains(value));
    }
}

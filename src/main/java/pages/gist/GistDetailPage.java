package pages.gist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GistDetailPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public GistDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void deleteGist() {
        // Klik tombol Delete di halaman gist
        WebElement deleteButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-confirm*='delete this Gist']"))
        );
        deleteButton.click();

        // Tunggu toast/modal muncul, klik tombol delete di toast
        WebElement confirmDelete = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("button.Button--danger"))
        );
        confirmDelete.click();

        // Tunggu redirect ke halaman list gist
        wait.until(ExpectedConditions.urlMatches("https://gist.github.com/.*"));
    }
}

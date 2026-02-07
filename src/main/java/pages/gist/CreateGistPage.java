package pages.gist;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateGistPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CreateGistPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String createPublicGist(String fileName, String content) {
        WebElement fileNameInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("input[name='gist[contents][][name]'], input.js-gist-filename")
                )
        );
        fileNameInput.clear();
        fileNameInput.sendKeys(fileName);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".CodeMirror")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);",
                content
        );

        WebElement createButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-primary"))
        );
        createButton.click();

        wait.until(ExpectedConditions.urlContains("gist.github.com"));

        return driver.getCurrentUrl();
    }
}

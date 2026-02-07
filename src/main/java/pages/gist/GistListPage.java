package pages.gist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GistListPage {
    private WebDriver driver;

    public GistListPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getGistCount() {
        List<WebElement> gists = driver.findElements(By.cssSelector("div.gist-snippet"));
        return gists.size();
    }
}

package tests;

import base.BaseWebTest;
import config.WebConfig;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.auth.LoginPage;
import pages.gist.CreateGistPage;
import pages.gist.GistDetailPage;
import pages.gist.GistListPage;

public class GistTest extends BaseWebTest {

    @Test
    public void testCrudGist() {
        /* LOGIN */
        driver.get(WebConfig.BASE_URL + "/login");
        LoginPage login = new LoginPage(driver);
        login.login("wahyuhatake20@gmail.com", "medan16031997");

        String username = "wahyunainggolan";

        /* CREATE */
        driver.get("https://gist.github.com/");
        CreateGistPage create = new CreateGistPage(driver);
        String gistUrl = create.createPublicGist("test-gist.txt", "hello world");
        driver.get(gistUrl);
        GistDetailPage detail = new GistDetailPage(driver);

        /* LIST */
        driver.get("https://gist.github.com/" + username);
        GistListPage list = new GistListPage(driver);
        Assert.assertTrue(list.getGistCount() > 0, "Gist list should have at least one gist");

        /* DELETE */
        driver.get(gistUrl);
//        detail.deleteGist();
//        /* VERIFY DELETE */
//        driver.get("https://gist.github.com/" + username);
//        Assert.assertTrue(list.getGistCount() == 0, "Gist list should be empty after delete");
    }
}

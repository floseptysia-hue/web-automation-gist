package tests;

import base.BaseWebTest;
import config.WebConfig;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.auth.LoginPage;
import pages.gist.CreateGistPage;
import pages.gist.GistDetailPage;
import pages.gist.GistListPage;

public class GistTest extends BaseWebTest {
    @Test
    public void testCrudGist() {
        try {
            /* LOGIN */
            driver.get(WebConfig.BASE_URL + "/login");
            LoginPage login = new LoginPage(driver);
            login.login(WebConfig.EMAIL_GITHUB, WebConfig.PASSWORD_GITHUB);
            Reporter.log("Login berhasil untuk user " + WebConfig.EMAIL_GITHUB, true);

            /* CREATE */
            driver.get(WebConfig.BASE_URL);
            CreateGistPage create = new CreateGistPage(driver);
            String gistUrl = create.createPublicGist("test-gist.txt", "hello world");
            driver.get(gistUrl);
            Reporter.log("Gist berhasil dibuat di URL: " + gistUrl, true);

            /* LIST */
            driver.get(WebConfig.BASE_URL + "/" + WebConfig.USERNAME);
            GistListPage list = new GistListPage(driver);
            Assert.assertTrue(list.getGistCount() > 0, "Gist list should have at least one gist");
            Reporter.log("Gist list berhasil diverifikasi, total gist: " + list.getGistCount(), true);

            /* DELETE */
            driver.get(gistUrl);
            // detail.deleteGist();
            // driver.get("https://gist.github.com/" + username);
            // Assert.assertTrue(list.getGistCount() == 0, "Gist list should be empty after delete");
            Reporter.log("Step DELETE belum dijalankan (komentar)", true);

        } catch (Exception e) {
            Reporter.log("Test gagal: " + e.getMessage(), true);
            Assert.fail("Test gagal karena exception: " + e.getMessage());
        }
    }
}

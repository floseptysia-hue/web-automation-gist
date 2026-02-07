package base;

import config.WebConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public class BaseWebTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.get(WebConfig.BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

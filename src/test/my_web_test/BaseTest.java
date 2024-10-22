package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigLoader;
import utils.TestUtils;
import utils.WebDriverFactory;

public class BaseTest {
    WebDriver driver;


    //define chromedriver or other from setting file
    //maybe headless possibility in config
    //resources add gitignore for files

    @BeforeSuite
    public void loadConfig() {
        ConfigLoader.getProperty("sleep.time");
    }

    @BeforeMethod
    public void setUpTestValues() {

        // test environment  LiveServer/web
        driver = WebDriverFactory.initializeChromeDriver();
        boolean testEnvironment = ConfigLoader.getEnvironmentProperty("test.local");
        String environmentStartPage = (testEnvironment) ? "http://127.0.0.1:5500/index.html" : "https://teserat.github.io/welcome/";
        driver.get(environmentStartPage);

    }

    @AfterMethod
    public void onTestEnd() {
        int sleepTime = ConfigLoader.getIntProperty("sleep.time");
        TestUtils.sleep(sleepTime);
        driver.quit();
    }
}
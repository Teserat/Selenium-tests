package my_web_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigLoader;
import utils.TestUtils;

public class BaseTest {
    WebDriver driver;

    //make config  - config.properties - for some fast switches like in waits/sleeps?
    //define chromedriver or other from setting file
    //define local or url test from setting file
    //maybe headless possibility in config

    @BeforeSuite
    public void loadConfig() {
        ConfigLoader.getProperty("sleep.time");
    }

    @AfterMethod
    public void onTestEnd() {
        int sleepTime = ConfigLoader.getIntProperty("sleep.time");
        TestUtils.sleep(sleepTime);
        driver.quit();
    }
}
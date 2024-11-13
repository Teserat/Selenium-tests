package my_web_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.ConfigLoader;
import utils.TestListener;
import utils.TestUtils;
import utils.WebDriverFactory;

@Listeners(value = {TestListener.class})
public class BaseTest {
    WebDriver driver;

    //ToDo some extras
    //define chromedriver or other from setting file

    @BeforeSuite
    public void loadConfig() {
        ConfigLoader.getProperty("sleep.time");
    }

    @BeforeMethod
    public void setUpTestValues() {

        // browser pick
        String browser = ConfigLoader.getProperty("test.browser");

        switch (browser) {
            case "chrome" -> driver = WebDriverFactory.initializeChromeDriver();
            case "headless" -> driver = WebDriverFactory.initializeChromeDriverHeadless();
            case "edge" -> driver = WebDriverFactory.initializeEdgeDriver();
            case "firefox" -> driver = WebDriverFactory.initializeFirefoxDriver();
            default -> {
                System.out.println("Wrong driver in config");
                driver = null;
            }
        }

        // test environment  LiveServer/web
        boolean testEnvironment = ConfigLoader.getEnvironmentProperty("test.local");
        String environmentStartPage = (testEnvironment) ? "http://127.0.0.1:5500/index.html" : "https://teserat.github.io/welcome/";
        driver.get(environmentStartPage);
    }

    @AfterMethod
    public void onTestEnd() {
        int sleepTime = ConfigLoader.getIntProperty("sleep.time");
        TestUtils.sleep(sleepTime);
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Driver close error: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
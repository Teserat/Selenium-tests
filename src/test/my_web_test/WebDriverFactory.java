package my_web_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
    public static WebDriver initializeChromeDriver() {
        // Setup WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Workaround for chromedriver v127
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");

        // Initialize ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        return driver;
    }
}

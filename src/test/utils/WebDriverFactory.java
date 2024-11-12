package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

    public static WebDriver initializeChromeDriverHeadless() {
        // Setup WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Workaround for chromedriver v127
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");

        // Initialize ChromeDriver with options
        return new ChromeDriver(options);
    }

    public static WebDriver initializeFirefoxDriver() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Maximize the browser window
        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver initializeEdgeDriver() {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Maximize the browser window
        driver.manage().window().maximize();

        return driver;
    }
}


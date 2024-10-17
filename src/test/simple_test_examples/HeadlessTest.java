package simple_test_examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTest {

    @Test
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        // Initialization Chrome options
        ChromeOptions options = new ChromeOptions();

        // Set headless mode - without GUI
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        // WebDriver Initialization from ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.example.com");

        driver.quit();
    }

}

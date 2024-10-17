package simple_test_examples;

import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.TestUtils;

public class ResizeBrowserTest {

    @Test
    public void test() throws InterruptedException {

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // web size management
        driver.manage().window().maximize();
        TestUtils.sleep(800);
        Dimension windowSize = new Dimension(250, 300);
        driver.manage().window().setSize(windowSize);

        // Go to Google
        driver.get("https://www.google.com");

        // Print title of the page
        System.out.println("Title: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UseChromeDriverFromDiscCaseTest {

    @Test
    @Ignore //will not work, needed current Chromedriver
    public void testGoogleTitle() throws InterruptedException {
        // Set the path to chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Projekty\\Soft\\chromedriver-win64-125\\chromedriver.exe");
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        // Go to Google
        driver.get("https://www.google.com");
        // Get title of the page
        String title = driver.getTitle();
        // Print title of the page
        System.out.println("Title: " + title);
        // Assert the title
        assertEquals("Google", title);
        // Close the browser
        driver.quit();
    }
}
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AnotherTest {

    @Test
    public void test() {


        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Go to Google
        driver.get("https://www.google.com");

        // Print title of the page
        System.out.println("Title: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}

package simple_test_examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import utils.TestUtils;

public class DriverCloseQuitExampleTest {


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://teserat.github.io/welcome/testWeb5.html");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://www.google.pl', 'blank', 'height=300', 'width=400')");

        // close first browser
        driver.close();

        // close driver
        TestUtils.sleep(1000);
        driver.quit();
    }
}
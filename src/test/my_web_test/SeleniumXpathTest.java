package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumXpathTest {

    // tests on a specially prepared website
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        //Initialize Chrome options
        driver = new ChromeDriver();
        driver.manage().
                window().
                maximize();
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");
    }

    @Test
    public void seleniumXpathTest() {

        //better precision with second case
        //By button1 = By.xpath("//*[@id=\"testID1\"]");
        By button1 = By.xpath("//label[@id=\"testID1\"]");
        WebElement clickOnPokazObrazek1 = driver.findElement(button1);
        clickOnPokazObrazek1.click();

        TestUtils.sleep(2000);
        driver.quit();

    }
}

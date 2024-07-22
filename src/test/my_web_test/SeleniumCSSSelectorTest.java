package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumCSSSelectorTest {
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
    public void seleniumCSSSelectorTest() {

        //finding elements
        //by ID
        By cssIDClickableButton = By.cssSelector("#testID1");
        driver.findElement(cssIDClickableButton).click();

        //by class
        By cssClass = By.cssSelector(".images");
        By cssClass2 = By.cssSelector("[class='fun-section'");
        driver.findElement(cssClass);
        driver.findElement(cssClass2);

        //by tag
        By cssTag = By.cssSelector("h1");
        driver.findElement(cssTag);

        //by CSS name (or anything else)
        By cssName = By.cssSelector("[name='imageSelector'");
        driver.findElement(cssName);

        driver.quit();
    }


    public static void sleep(int sleepTimeInMillis) {
        try {
            Thread.sleep(sleepTimeInMillis); // 5000 miliseconds = 5 seconds

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

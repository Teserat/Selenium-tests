package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicActionsTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        // workaround for chromedriver v127
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");

        //Initialize Chrome options
        driver = new ChromeDriver(options);
        driver.manage().
                window().
                maximize();
        driver.get("http://127.0.0.1:5500/index.html"); //local host
        //driver.get("https://teserat.github.io/welcome/");
    }

    @Test
    public void performAction() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        elementsPageLink.click();
        driver.findElement(By.id("clickOnMe")).click();

        TestUtils.sleep(3000);
        driver.quit();
    }
}

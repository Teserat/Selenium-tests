package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicActionsTest {
    WebDriver driver;

    @BeforeMethod
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
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");
    }

    @Test
    public void performAction1() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        elementsPageLink.click();
        driver.findElement(By.id("clickOnMe")).click();

        TestUtils.sleep(1500);
        driver.quit();
    }

    @Test
    public void performAction2() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        elementsPageLink.click();
        WebElement name = driver.findElement(By.id("fname"));
        name.sendKeys("Szymon");
        TestUtils.sleep(500);
        name.clear();
        TestUtils.sleep(500);
        name.sendKeys("Jendrek");
        TestUtils.sleep(500);
        //xpath
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        TestUtils.sleep(500);
        name = driver.findElement(By.id("fname"));
        name.sendKeys("Mike");
        //css selector
        driver.findElement(By.cssSelector("input[type='submit'")).click();

        TestUtils.sleep(1000);
        driver.quit();
    }

    @Test
    public void performAction3() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        elementsPageLink.click();
        TestUtils.sleep(500);
        driver.findElement(By.cssSelector("[type='checkbox'")).click();
        TestUtils.sleep(400);
        driver.findElement(By.cssSelector("[value='option3'")).click();

        TestUtils.sleep(1500);
        driver.quit();
    }


}

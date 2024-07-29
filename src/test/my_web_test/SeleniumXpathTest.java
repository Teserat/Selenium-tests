package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

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

        //Others
        //


        // difrence with  double // and single /
        //double give all / single give first
        driver.get("https://teserat.github.io/welcome/testWeb1.html");
        By element1 = By.xpath("/html/body/div");
        By element2 = By.xpath("/html/body//div");
        List <WebElement> test1 = driver.findElements(element1);
        List <WebElement> test2 = driver.findElements(element2);
        System.out.println(element1 + " : " +test1.size());
        System.out.println(element2 + " : " +test2.size());


        TestUtils.sleep(1000);
        driver.quit();

    }
}

package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

public class WaitTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.initializeChromeDriver();
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");
    }

    // test showing that the text does not exist after opening the page
    @Test
    public void verificationIfTextIsInvisibleOnsStart1() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide6 - Wait test"));
        elementsPageLink.click();
        //TestUtils.sleep(4000);
        //using list - will not throw an exception if the element does not exist (like normal find element)
        List<WebElement> elements = driver.findElements(By.xpath("//div[text()='Hello']"));
        Assert.assertTrue(elements.isEmpty(), "Element 'Hello' should not exist, but here it is.");
    }


    // test with wait sleep
    @Test
    public void verificationIfTextIsInvisibleWithSleep() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide6 - Wait test"));
        elementsPageLink.click();
        TestUtils.sleep(4000);
        WebElement test = driver.findElement(By.xpath("//div[text()='Hello']"));
        System.out.println(test.getText());
        Assert.assertEquals(test.getText(), "Hello");
    }

    //test with Implicit - whole test wait on every step

    //test with WebDriverWait (child FluentWait)

    //test with FluentWait - no exceptions inside, like in WebDriverWait

    //ExpectedConditions

    @AfterMethod
    public  void onTestEnd(){
        TestUtils.sleep(800);
        driver.quit();
    }
}

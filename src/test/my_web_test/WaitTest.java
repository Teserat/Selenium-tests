package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HUBPage;
import pages.WelcomePage;
import utils.TestUtils;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WaitTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide6WaitTest();
    }

    // test showing that the text does not exist after opening the page
    @Test
    public void verificationIfTextIsInvisibleOnsStart1() {

        //TestUtils.sleep(4000);
        //using list - will not throw an exception if the element does not exist (like normal find element)
        List<WebElement> elements = driver.findElements(By.xpath("//div[text()='Hello']"));
        Assert.assertTrue(elements.isEmpty(), "Element 'Hello' should not exist, but here it is.");
    }

    // test with wait sleep
    @Test
    public void verificationVisibilityTextWithSleep() {


        TestUtils.sleep(4000);
        WebElement test = driver.findElement(By.xpath("//div[text()='Hello']"));
        System.out.println(test.getText());
        Assert.assertEquals(test.getText(), "Hello");
    }

    //test with Implicit - whole test wait on every step
    @Test
    public void verificationVisibilityTextWithImplicit() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement test = driver.findElement(By.xpath("//div[text()='Hello']"));
        System.out.println(test.getText());
        Assert.assertEquals(test.getText(), "Hello");
    }

    //test with WebDriverWait (child FluentWait)
    @Test
    public void verificationVisibilityTextWithWebDriverWait() {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Hello']")));

        WebElement test = driver.findElement(By.xpath("//div[text()='Hello']"));
        System.out.println(test.getText());
        Assert.assertEquals(test.getText(), "Hello");
    }

    //test with FluentWait - no exceptions inside, like in WebDriverWait
    @Test
    public void verificationVisibilityTextWithFluentWait() {


        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Hello']")));

        WebElement test = driver.findElement(By.xpath("//div[text()='Hello']"));
        System.out.println(test.getText());
        Assert.assertEquals(test.getText(), "Hello");
    }

    //Test with wait with own expression
    @Test
    public void verificationVisibilityTextWithAddingElementListFluentWait() {

        TestUtils.waitForElementToExistFluent(driver, By.xpath("//div[text()='Hello']"));
    }

    //Test with wait with own expression (change for lambda expression)
    @Test
    public void verificationVisibilityTextWithAddingElementListFluentWaitLambda() {

        TestUtils.waitForElementToExistFluentLambdaMethod(driver, By.xpath("//div[text()='Hello']"));
    }

    @Test
    public void verificationVisibilityWithUsePredefinedMethodInTestUtils(){
        System.out.println("test");
        TestUtils.waitForElementToExist(driver, By.xpath("//*[@id='fast']"));
    }
}
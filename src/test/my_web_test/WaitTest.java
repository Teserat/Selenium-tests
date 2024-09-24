package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

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
    public void verificationVisibilityTextWithSleep() {

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
    @Test
    public void verificationVisibilityTextWithImplicit() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide6 - Wait test"));
        elementsPageLink.click();


        WebElement test = driver.findElement(By.xpath("//div[text()='Hello']"));
        System.out.println(test.getText());
        Assert.assertEquals(test.getText(), "Hello");
    }

    //test with WebDriverWait (child FluentWait)
    @Test
    public void verificationVisibilityTextWithWebDriverWait() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide6 - Wait test"));
        elementsPageLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Hello']")));

        WebElement test = driver.findElement(By.xpath("//div[text()='Hello']"));
        System.out.println(test.getText());
        Assert.assertEquals(test.getText(), "Hello");
    }

    //test with FluentWait - no exceptions inside, like in WebDriverWait
    @Test
    public void verificationVisibilityTextWithFluentWait() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide6 - Wait test"));
        elementsPageLink.click();

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
    public void verificationVisibilityTextWithAddingElementList() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide6 - Wait test"));
        elementsPageLink.click();

        waitForElementToExist(By.xpath("//div[text()='Hello']"));
    }
    //ExpectedConditions


    //Method used in tests
    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);

        //wait until happen (if not = infinity loop)
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver Boolean) {
                List<WebElement> elements = driver.findElements(locator);
                if (elements.size() > 0) {
                    System.out.println("Element is on website");
                    return true;
                } else {
                    System.out.println("Element is not on website");
                    return false;
                }
            }
        });
    }

    @AfterMethod
    public void onTestEnd() {
        TestUtils.sleep(800);
        driver.quit();
    }
}

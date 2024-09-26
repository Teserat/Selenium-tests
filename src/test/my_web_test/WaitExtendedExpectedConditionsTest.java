package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitExtendedExpectedConditionsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.initializeChromeDriver();
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");
    }
    @Test
    public void visibilityOfElementLocatedTest() {

        //ToDo make to tests by method in every class
        driver.findElement(By.linkText("Rozchodniak")).click();
        driver.findElement(By.linkText("TestSide2 - mix elements")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delayedButton")));
        Assert.assertTrue(button.isDisplayed(), "Button should be visible");

    }
    @Test
    public void elementToBeClickableTest() {

        driver.findElement(By.linkText("Rozchodniak")).click();
        driver.findElement(By.linkText("TestSide2 - mix elements")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clickableButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("delayedButton")));
        clickableButton.click();
        Assert.assertTrue(clickableButton.isEnabled(), "Button should be clickable");


    }

    @AfterMethod
    public void onTestEnd() {
        TestUtils.sleep(800);
        driver.quit();
    }
}

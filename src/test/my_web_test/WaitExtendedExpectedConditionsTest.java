package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HUBPage;
import pages.WelcomePage;
import utils.TestUtils;

import java.time.Duration;

public class WaitExtendedExpectedConditionsTest extends BaseTest {

    @Test
    public void visibilityOfElementLocatedTest() {

        WelcomePage welcomePage = new WelcomePage(driver);
        HUBPage hubPage = new HUBPage(driver);
        welcomePage.RozchodniakClick();
        hubPage.TestSide2MixElementsClick();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delayedButton")));
        Assert.assertTrue(button.isDisplayed(), "Button should be visible");
    }

    @Test
    public void elementToBeClickableTest() {

        WelcomePage welcomePage = new WelcomePage(driver);
        HUBPage hubPage = new HUBPage(driver);
        welcomePage.RozchodniakClick();
        hubPage.TestSide2MixElementsClick();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clickableButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("delayedButton")));
        clickableButton.click();
        Assert.assertTrue(clickableButton.isEnabled(), "Button should be clickable");
    }

    @Test
    public void elementToBeClickableAlertTest() {

        WelcomePage welcomePage = new WelcomePage(driver);
        HUBPage hubPage = new HUBPage(driver);
        welcomePage.RozchodniakClick();
        hubPage.TestSide2MixElementsClick();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clickableButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("delayedButton")));
        clickableButton.click();

        WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        alertWait.until(ExpectedConditions.alertIsPresent());

        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "This is a delayed alert!", "Alert text should be 'This is a delayed alert!'");

        TestUtils.sleep(500);
        driver.switchTo().alert().accept();
    }

    @Test
    public void elementToBeOnModal() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide7OknoModalne();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[text()='Po naciśnięciu guzika otworzy się okno modalne']")).click();

        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModal")));
        Assert.assertTrue(modal.isDisplayed(), "Modal should be visible");

    }
}
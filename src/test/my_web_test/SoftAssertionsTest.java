package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsTest {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.initializeChromeDriver();
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");
        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide5 - mix elements 2"));
        elementsPageLink.click();
    }

    @Test
    public void verifyPageTitleWithSoftAssert() {
        //if broke 1 of 2 or both asserts, code will stop on end assertAll();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Strona testowa z wszystkimi elementami HTML";
        softAssert.assertEquals(actualTitle, expectedTitle, "Wrong web title!");
        System.out.println(driver.getCurrentUrl());
        softAssert.assertTrue(driver.getCurrentUrl().contains("welcome"), "URL not contains 'testowa'!");

        softAssert.assertAll();
    }

    @AfterMethod
    public void onTestEnd() {
        TestUtils.sleep(800);
        driver.quit();
    }
}

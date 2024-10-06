package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertionsTest {

    WebDriver driver;

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
    public void assertEqualsTest(){
        String expectedTitle = "Strona testowa z wszystkimi elementami HTML";
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @Test
    public void assertIsDisplayedTest(){
        WebElement element = driver.findElement(By.xpath("/html/body/form/fieldset/button[1]"));
        Assert.assertTrue(element.isDisplayed(), "Element nie jest widoczny!");
    }

    @Test
    public void verifyElementExistsTest() {
            driver.findElement(By.xpath("//h1"));
            Assert.assertTrue(true, "Element został znaleziony!");
    }


    @AfterMethod
    public void onTestEnd() {
        TestUtils.sleep(800);
        driver.quit();
    }
}


//ToDo in class that all are in same page change page link in BeforeMethod
//ToDo maybe some changes in base class with maintain WebDriver driver; driver initialization method just to pic one; or more reusable things
//ToDo add better selectors
//ToDo add some testWithAssertFail
package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestUtils;
import utils.WebDriverFactory;

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
    public void assertEqualsTest() {
        String expectedTitle = "Strona testowa z wszystkimi elementami HTML";
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @Test
    public void assertIsDisplayedTest() {
        WebElement element = driver.findElement(By.xpath("/html/body/form/fieldset/button[1]"));
        Assert.assertTrue(element.isDisplayed(), "Element is not visible!");
    }

    @Test  //not usable, better isDisplayed
    public void assertFailTest() {
        try {
            driver.findElement(By.xpath("//h1"));
        } catch (NoSuchElementException e) {
            Assert.fail("Element not exist!");
        }
    }

    @Test
    public void assertFalseTest() {
        WebElement element = driver.findElement(By.xpath("/html/body/form/fieldset/button[1]"));
        Assert.assertFalse(element.isSelected(), "Element button is selected?!");
    }

    @Test
    public void assertNull() {
        WebElement inputElement = driver.findElement(By.id("pustePole"));

        String placeholder = inputElement.getAttribute("placeholder");
        if ("".equals(placeholder)) {//forced null if html gives wrong format
            placeholder = null;
        }
        Assert.assertNull(placeholder, "expectet value null in 'placeholder', but it is not null!");

    }

    @Test
    public void assertNotNull() {
        driver.findElement(By.xpath("//h1"));
        WebElement element = driver.findElement(By.xpath("//h1"));
        Assert.assertNotNull(element, "Element is null!");
    }

    @AfterMethod
    public void onTestEnd() {
        TestUtils.sleep(800);
        driver.quit();
    }
}


//ToDo in class that all are in same page change page link in BeforeMethod
//ToDo add better selectors
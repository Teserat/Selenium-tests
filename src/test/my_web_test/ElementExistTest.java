package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementExistTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.initializeChromeDriver();
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");
    }

    @Test
    public void elementExist() {
        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        elementsPageLink.click();

        //Use specific method for check if element exist
        System.out.println(elementExist(By.id("clickOnMe3")));//true
        System.out.println(elementExist(By.id("clickOnMe4")));//false

        System.out.println(elementExistAtLastOnce(By.id("clickOnMe3")));//true
        System.out.println(elementExistAtLastOnce(By.id("clickOnMe4")));//false

        //Check if element exist
        System.out.println(driver.findElement(By.id("clickOnMe3")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[contains(text(), 'there is nothing here, keep scrolling')]")).isDisplayed());//false

    }

    @Test
    public void elementDisabled() {
        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        elementsPageLink.click();

        //false
        WebElement enabledElement = driver.findElement(By.id("clickOnMe99"));
        System.out.println(enabledElement.isEnabled());
        Assert.assertFalse(enabledElement.isEnabled(), "The item should be disabled");

        //true
        WebElement notEnabledElement = driver.findElement(By.id("clickOnMe2"));
        System.out.println(notEnabledElement.isEnabled());
        Assert.assertTrue(notEnabledElement.isEnabled(), "The item should be enabled");

    }

    public boolean elementExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean elementExistAtLastOnce(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    @AfterMethod
    public void onTestEnd() {
        TestUtils.sleep(800);
        driver.quit();
    }
}

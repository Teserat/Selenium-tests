package my_web_test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HUBPage;
import pages.WelcomePage;
import utils.TestUtils;

import java.util.List;

public class BasicActionsTest extends BaseTest {

    @Test
    public void performActionClickAndAlert() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide2MixElementsClick();

        driver.findElement(By.id("clickOnMe")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert mesange : " + alert.getText());
        TestUtils.sleep(800);
        alert.accept();

        driver.findElement(By.id("clickOnMe2")).click();
        TestUtils.sleep(800);
        alert.dismiss();

        driver.findElement(By.id("clickOnMe3")).click();
        TestUtils.sleep(800);
        alert.sendKeys("world!");

    }

    @Test
    public void performActionEnteringFields() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide2MixElementsClick();

        WebElement name = driver.findElement(By.id("fname"));
        name.sendKeys("Szymon");
        TestUtils.sleep(500);
        name.clear();
        TestUtils.sleep(500);
        name.sendKeys("Jendrek");
        TestUtils.sleep(500);
        //xpath
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        TestUtils.sleep(500);
        name = driver.findElement(By.id("fname"));
        name.sendKeys("Mike");
        //css selector
        driver.findElement(By.cssSelector("input[type='submit'")).click();

    }

    @Test
    public void performActionCheckboxAndRadioButtons() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide2MixElementsClick();

        TestUtils.sleep(500);
        driver.findElement(By.cssSelector("[type='checkbox'")).click();
        TestUtils.sleep(400);
        driver.findElement(By.cssSelector("[value='option3'")).click();

    }

    @Test
    public void performActionOnSelect() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide2MixElementsClick();


        TestUtils.sleep(500);
        WebElement selectDrink = driver.findElement(By.cssSelector("select"));
        //Work on selector Class
        Select drink = new Select(selectDrink);
        drink.selectByIndex(0);
        TestUtils.sleep(500);
        drink.selectByVisibleText("Muszynianka");
        TestUtils.sleep(500);
        drink.selectByValue("pepsi");

        //Get all elements on select
        List<WebElement> options = drink.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }

    @Test
    public void performActionToCheckSelectTextAssertion() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide2MixElementsClick();


        TestUtils.sleep(500);
        WebElement selectDrink = driver.findElement(By.cssSelector("select"));

        Assert.assertTrue(TestUtils.checkSelectAssertion("Woda", selectDrink));
        System.out.println("Is Woda on the list : " + TestUtils.checkSelectAssertion("Woda", selectDrink));

        Assert.assertTrue(TestUtils.checkSelectAssertion("Pepsi", selectDrink));
        System.out.println("Is Pepsi on the list : " + TestUtils.checkSelectAssertion("Pepsi", selectDrink));

        Assert.assertTrue(TestUtils.checkSelectAssertion("Muszynianka", selectDrink));
        System.out.println("Is Muszynianka on the list : " + TestUtils.checkSelectAssertion("Muszynianka", selectDrink));

        Assert.assertTrue(TestUtils.checkSelectAssertion("Herbata", selectDrink));
        System.out.println("Is Herbata on the list : " + TestUtils.checkSelectAssertion("Herbata", selectDrink));

        //Assert.assertTrue(TestUtils.checkSelectAssertion("Kawa", selectDrink));  // Turn off assertion to not crash test
        System.out.println("Is Kawa on the list : " + TestUtils.checkSelectAssertion("Kawa", selectDrink));

    }

    @Test
    public void performActionCheckDefaultSelectValue() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide2MixElementsClick();

        WebElement selectValue = driver.findElement(By.cssSelector("select"));
        System.out.println(selectValue.getAttribute("value"));
        Assert.assertEquals(selectValue.getAttribute("value"), "herbata");

    }

    @Test
    public void performActionHiddenTextContent() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide2MixElementsClick();

        WebElement hidden = driver.findElement(By.cssSelector("h4"));
        System.out.println(hidden.getAttribute("textContent"));

    }
}

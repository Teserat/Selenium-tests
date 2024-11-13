package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HUBPage;
import pages.WelcomePage;

public class ActionsTest extends BaseTest {

    @Test
    public void performActionRightMouseClick() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide2MixElementsClick();

        //class actions, parameter driver
        Actions actions = new Actions(driver);
        //actions.contextClick().perform();
        actions.contextClick(driver.findElement(By.cssSelector("[type='text']"))).perform();
    }

    @Test
    public void performActionDoubleMouseClick() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide2MixElementsClick();

        //class actions, parameter driver
        Actions actions = new Actions(driver);
        //actions.contextClick().perform();
        actions.doubleClick(driver.findElement(By.id("dubleClick"))).perform();
    }

    @Test
    public void performActionMouseover() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide2MixElementsClick();

        //class actions, parameter driver
        Actions actions = new Actions(driver);
        //actions.contextClick().perform();
        actions.moveToElement(driver.findElement(By.tagName("h1"))).perform();
    }
}

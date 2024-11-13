package my_web_test;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.HUBPage;
import pages.WelcomePage;
import utils.TestUtils;

public class ExecutorTest extends BaseTest {

    @Test
    public void performActionClickUsingJavaScriptExecutor() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide2MixElementsClick();

        //TestUtils.sleep(500);
        WebElement element = driver.findElement(By.cssSelector("[type='checkbox'"));

        //element.click();
        //OR if not working .click():
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

    }

    @Test
    public void performActionSetAttributeUsingJavaScriptExecutor() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide2MixElementsClick();

        //TestUtils.sleep(500);
        WebElement element = driver.findElement(By.cssSelector("[name='fname']"));

        //value addition (when sendKeys don't work)
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('value','Grzesiek');", element);

    }
}

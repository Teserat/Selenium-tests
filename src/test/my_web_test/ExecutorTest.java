package my_web_test;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utils.TestUtils;

public class ExecutorTest extends BaseTest {

    @Test
    public void performActionClickUsingJavaScriptExecutor() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        elementsPageLink.click();
        TestUtils.sleep(500);
        WebElement element = driver.findElement(By.cssSelector("[type='checkbox'"));

        //element.click();
        //OR if not working .click():
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

    }

    @Test
    public void performActionSetAttributeUsingJavaScriptExecutor() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        elementsPageLink.click();
        TestUtils.sleep(500);
        WebElement element = driver.findElement(By.cssSelector("[name='fname']"));

        //value addition (when sendKeys don't work)
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('value','Grzesiek');", element);

    }
}

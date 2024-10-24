package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends BaseTest{

    @Test
    public void performActionRightMouseClick() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        System.out.println("Site : " + elementsPageLink.getText());
        elementsPageLink.click();

        //class actions, parameter driver
        Actions actions = new Actions(driver);
        //actions.contextClick().perform();
        actions.contextClick(driver.findElement(By.cssSelector("[type='text']"))).perform();
    }

    @Test
    public void performActionDoubleMouseClick() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        System.out.println("Site : " + elementsPageLink.getText());
        elementsPageLink.click();

        //class actions, parameter driver
        Actions actions = new Actions(driver);
        //actions.contextClick().perform();
        actions.doubleClick(driver.findElement(By.id("dubleClick"))).perform();
    }

    @Test
    public void performActionMouseover() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        System.out.println("Site : " + elementsPageLink.getText());
        elementsPageLink.click();

        //class actions, parameter driver
        Actions actions = new Actions(driver);
        //actions.contextClick().perform();
        actions.moveToElement(driver.findElement(By.tagName("h1"))).perform();
    }
}

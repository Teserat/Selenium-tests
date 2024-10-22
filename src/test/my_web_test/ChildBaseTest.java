package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//  only for tests, for use to all others tests
public class ChildBaseTest extends BaseTest{

    @Test
    public void performActionRightMouseClick() {
        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        elementsPageLink.click();

        String pageTitle = driver.getTitle();
        System.out.println("Site " +pageTitle);
    }
}

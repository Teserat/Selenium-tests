package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//  only for tests
public class ChildBaseTest extends BaseTest{
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.initializeChromeDriver();
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");
        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        elementsPageLink.click();

    }

    @Test
    public void performActionRightMouseClick() {
        String pageTitle = driver.getTitle();
        System.out.println("Site " +pageTitle);
    }

    @AfterMethod
    public void onTestEnd() {
        TestUtils.sleep(800);
        driver.quit();
    }
}

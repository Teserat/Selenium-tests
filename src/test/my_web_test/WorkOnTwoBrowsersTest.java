package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HUBPage;
import pages.WelcomePage;
import utils.TestUtils;

import java.util.Set;

public class WorkOnTwoBrowsersTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide3NewBrowser();
    }

    @Test
    public void webTest() {

        //save current name of browser
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.cssSelector("button")).click();

        //change work place for test
        Set<String> windowsNames = driver.getWindowHandles();
        for (String window : windowsNames) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }

        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        agreeButton.click();
        TestUtils.sleep(500);
        driver.close();
        driver.switchTo().window(currentWindow);

        driver.findElement(By.linkText("Kliknij, aby otworzyć nowe okno"));
        driver.navigate().back();

    }

    @Test
    public void webTestIframe() {

        //driver.switchTo().frame(0); //index
        //---or selector
        WebElement iframe = driver.findElement(By.cssSelector("[src='testWeb2.html']"));
        driver.switchTo().frame(iframe);
        //---or id or name
        //driver.switchTo().frame("testIframe");

        driver.findElement(By.id("fname")).sendKeys("Czupakabra!!!");
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement((By.tagName("h1"))).getText());

    }
}
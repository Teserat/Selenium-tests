package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WorkOnTwoBrowsersTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.initializeChromeDriver();
        driver.get("http://127.0.0.1:5500/index.html"); //local host
        //driver.get("https://teserat.github.io/welcome/");
    }

    @Test
    public void webTest() {
        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide3 - newBrowser"));
        System.out.println("Site : " + elementsPageLink.getText());
        elementsPageLink.click();

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

        // @ToDo Add accept agree to TestUtilies

        driver.switchTo().window(currentWindow);

        driver.findElement(By.linkText("Kliknij, aby otworzyć nowe okno"));
        driver.navigate().back();

        TestUtils.sleep(1500);
        driver.quit();
    }

    @Test
    public void webTestIframe() {
        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide3 - newBrowser"));
        System.out.println("Site : " + elementsPageLink.getText());
        elementsPageLink.click();

        driver.switchTo().frame(0);
        driver.findElement(By.id("fname")).sendKeys("Czupakabra!!!");
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement((By.tagName("h1"))).getText());

        TestUtils.sleep(1500);
        driver.quit();

    }


}
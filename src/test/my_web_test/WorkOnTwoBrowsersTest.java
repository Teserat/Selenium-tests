package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class WorkOnTwoBrowsersTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        // workaround for chromedriver v127
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");

        //Initialize Chrome options
        driver = new ChromeDriver(options);
        driver.manage().
                window().
                maximize();
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");
    }

    @Test
    public void webTest (){
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
        for(String window : windowsNames){
            if(!window.equals(currentWindow)){
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
}
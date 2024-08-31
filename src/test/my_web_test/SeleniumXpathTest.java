package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class SeleniumXpathTest {

    // tests on a specially prepared website
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.initializeChromeDriver();
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");
    }

    @Test
    public void seleniumXpathTest() {

        //better precision with second case
        //By button1 = By.xpath("//*[@id='testID1']");
        By button1 = By.xpath("//label[@id='testID1']");
        //By button1 = By.xpath("//label[contains(@id,'tID1')]");
        WebElement clickOnPokazObrazek1 = driver.findElement(button1);
        clickOnPokazObrazek1.click();

        //Looking for link title
        By link1 = By.xpath("//a[text()='Pixabay Playlists']");
        WebElement webElwmentLink1 = driver.findElement(link1);

        //looking for part link title
        By link2 = By.xpath("//a[contains(text(),'abay Pl')]");
        WebElement webElwmentLink2 = driver.findElement(link2);

        //looking for eny element
        By link3 = By.xpath("//*");
        WebElement webElwmentLink3 = driver.findElement(link3);

        // using Index in selectors
        By indexTest1 = By.xpath("/html/body/div[5]/ul");
        By indexTest2 = By.xpath("//html/body/div[5]/ul/li[2]");
        By indexTest3 = By.xpath("(//html/body/div[5]/ul/li)[2]");
        By indexTest4 = By.xpath("(//html/body/div[5]/ul/li)[last()]");
        By indexTest5 = By.xpath("//html/body/div[5]/ul/li[last()]");

        WebElement elementIndexTest1 = driver.findElement(indexTest1);
        WebElement elementIndexTest2 = driver.findElement(indexTest2);
        WebElement elementIndexTest3 = driver.findElement(indexTest3);
        WebElement elementIndexTest4 = driver.findElement(indexTest4);
        WebElement elementIndexTest5 = driver.findElement(indexTest5);

        //System.out.println(elementIndexTest1.getText());
        System.out.println(elementIndexTest2.getText());
        System.out.println(elementIndexTest3.getText());
        System.out.println(elementIndexTest4.getText());
        System.out.println(elementIndexTest5.getText());

        // difrence with  double // and single /
        //double give all / single give first
        driver.get("https://teserat.github.io/welcome/testWeb1.html");
        By element1 = By.xpath("/html/body/div");
        By element2 = By.xpath("/html/body//div");
        List<WebElement> test1 = driver.findElements(element1);
        List<WebElement> test2 = driver.findElements(element2);
        System.out.println(element1 + " : " + test1.size());
        System.out.println(element2 + " : " + test2.size());

    }
    @AfterMethod
    public  void onTestEnd(){
        TestUtils.sleep(800);
        driver.quit();
    }
}

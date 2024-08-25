package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {
    WebDriver driver;

    @BeforeMethod
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
        driver.get("http://127.0.0.1:5500/index.html"); //local host
        //driver.get("https://teserat.github.io/welcome/");
    }

    @Test
    public void performActionClick() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        System.out.println("Site : " + elementsPageLink.getText());
        elementsPageLink.click();
        driver.findElement(By.id("clickOnMe")).click();

        TestUtils.sleep(1500);
        driver.quit();
    }

    @Test
    public void performActionEnteringFields() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        System.out.println("Site : " + elementsPageLink.getText());
        elementsPageLink.click();
        WebElement name = driver.findElement(By.id("fname"));
        name.sendKeys("Szymon");
        TestUtils.sleep(500);
        name.clear();
        TestUtils.sleep(500);
        name.sendKeys("Jendrek");
        TestUtils.sleep(500);
        //xpath
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        TestUtils.sleep(500);
        name = driver.findElement(By.id("fname"));
        name.sendKeys("Mike");
        //css selector
        driver.findElement(By.cssSelector("input[type='submit'")).click();

        TestUtils.sleep(1000);
        driver.quit();
    }

    @Test
    public void performActionCheckboxAndRadioButtons() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        System.out.println("Site : " + elementsPageLink.getText());
        elementsPageLink.click();
        TestUtils.sleep(500);
        driver.findElement(By.cssSelector("[type='checkbox'")).click();
        TestUtils.sleep(400);
        driver.findElement(By.cssSelector("[value='option3'")).click();

        TestUtils.sleep(1500);
        driver.quit();
    }

    @Test
    public void performActionOnSelect() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide2 - mix elements"));
        System.out.println("Site : " + elementsPageLink.getText());
        elementsPageLink.click();



        TestUtils.sleep(500);
        WebElement selectDrink = driver.findElement(By.cssSelector("select"));
        //Work on selector Class
        Select drink = new Select(selectDrink);
        drink.selectByIndex(0);
        TestUtils.sleep(500);
        drink.selectByVisibleText("Muszynianka");
        TestUtils.sleep(500);
        drink.selectByValue("pepsi");

        //Get all elements on select
        List<WebElement> options = drink.getOptions();

        for (WebElement option : options){
            System.out.println(option.getText());
        }

        TestUtils.sleep(1500);
        driver.quit();
    }
    //ToDo add timer and counter to "Site : TestSide2 - mix elements"
}

package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumCSSSelectorTest {
    // tests on a specially prepared website
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        //Initialize Chrome options
        driver = new ChromeDriver();
        driver.manage().
                window().
                maximize();
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");
    }

    @Test
    public void seleniumCSSSelectorTest() {

        //finding elements
        //by ID
        By cssIDClickableButton = By.cssSelector("#testID1");
        driver.findElement(cssIDClickableButton).click();
        System.out.println(cssIDClickableButton);

        //by class
        By cssClass = By.cssSelector(".images");
        By cssClass2 = By.cssSelector("[class='fun-section'");
        driver.findElement(cssClass);
        driver.findElement(cssClass2);
        System.out.println(cssClass);
        System.out.println(cssClass2);

        //by tag
        By cssTag = By.cssSelector("h1");
        driver.findElement(cssTag);
        System.out.println(cssTag);

        //by CSS name (or anything else)
        By cssName = By.cssSelector("[name='imageSelector'");
        driver.findElement(cssName);
        System.out.println(cssName);

        //finding every element on page + printing
        By allElementsOnPage = By.cssSelector("*");
        driver.findElement(allElementsOnPage);
        System.out.println(allElementsOnPage);

        // LOOKING BY relation parent children (first element find)
        By findTextRandomObrazki = By.cssSelector("div > h2");
        driver.findElement(findTextRandomObrazki);
        System.out.println(findTextRandomObrazki + "\n");

        // LOOKING BY relation parent children (first element find)
        By findMultiTextH2 = By.cssSelector("div > h2");
        List<WebElement> textElements = driver.findElements(findMultiTextH2);
        TestUtils.printAllList(textElements);

        // finding every element on emoji list (with using class or just ul)
        //By allEmotListElements = By.cssSelector("ul.emoticon-list li");
        By allEmotListElements = By.cssSelector("div ul");
        System.out.println("\n" + allEmotListElements + "\n");
        List<WebElement> elements = driver.findElements(allEmotListElements);
        TestUtils.printAllList(elements);
        System.out.println("\n");

        //same like before but just kids, not everything ToDo show that case in code
        By elementsFromContainer = By.cssSelector("div > ul");
        List<WebElement> test = driver.findElements(elementsFromContainer);
        TestUtils.printAllList(test);
        System.out.println("\n");

        By firstInputLabel = By.cssSelector("input + label");
        System.out.println(firstInputLabel);
        List<WebElement> test2 = driver.findElements(firstInputLabel);
        System.out.println(test2.size());

        By allInputLabel = By.cssSelector("input ~ label");
        System.out.println(allInputLabel);
        List<WebElement> test3 = driver.findElements(allInputLabel);
        System.out.println(test3.size());

        System.out.println("\n-----------------------------------------------------------\n");

        By combinSelector = By.cssSelector("img[alt='Losowe zdjęcie'");
        driver.findElement(combinSelector);
        System.out.println(combinSelector);









        driver.quit();
    }
}
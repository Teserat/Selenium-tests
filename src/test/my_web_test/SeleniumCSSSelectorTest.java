package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumCSSSelectorTest {
    // tests on a specially prepared website
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

        //finding every element on page
        By allElementsOnPage = By.cssSelector("*");
        driver.findElement(allElementsOnPage);
        System.out.println(allElementsOnPage);

        // LOOKING BY relation parent children (first element find)
        By findTextRandomObrazki = By.cssSelector("div > h2");
        driver.findElement(findTextRandomObrazki);
        System.out.println(findTextRandomObrazki + "\n");

        // LOOKING BY relation parent children (all elements)
        By findMultiTextH2 = By.cssSelector("div > ul");
        List<WebElement> textElements = driver.findElements(findMultiTextH2);
        TestUtils.printAllList(textElements);

        System.out.println("\n-----------------------------------------------------------\n");

        // finding every element on emoji list (with using class or just ul)
        //By allEmotListElements = By.cssSelector("ul.emoticon-list li");
        By allEmotListElements = By.cssSelector("div ul");
        System.out.println("\n" + allEmotListElements + "\n");
        List<WebElement> elements = driver.findElements(allEmotListElements);
        TestUtils.printAllList(elements);
        System.out.println("\n");

        //same like before but just kids, not everything - more in second CSS class
        By elementsFromContainer = By.cssSelector("div > ul");
        List<WebElement> test = driver.findElements(elementsFromContainer);
        TestUtils.printAllList(test);
        System.out.println("\n");

        System.out.println("\n-----------------------------------------------------------\n");

        // first element found in html
        By firstInputLabel = By.cssSelector("input + label");
        System.out.println(firstInputLabel);
        List<WebElement> test2 = driver.findElements(firstInputLabel);
        System.out.println(test2.size());

        // every element found in html
        By allInputLabel = By.cssSelector("input ~ label");
        System.out.println(allInputLabel);
        List<WebElement> test3 = driver.findElements(allInputLabel);
        System.out.println(test3.size());

        System.out.println("\n-----------------------------------------------------------\n");

        By combinSelector = By.cssSelector("img[alt='Losowe zdjęcie'");
        driver.findElement(combinSelector);
        System.out.println(combinSelector);

        //looking by part
        By partOfElementSelector = By.cssSelector("a[href*='tory.pl'");
        driver.findElement(partOfElementSelector).click();
        TestUtils.sleep(2000);
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        System.out.println(partOfElementSelector);

        //looking by beginning of element
        By beginningOfElementSelector = By.cssSelector("a[href^='https://chamsko'");
        driver.findElement(beginningOfElementSelector).click();
        TestUtils.sleep(2000);
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        System.out.println(beginningOfElementSelector);

        //looking by end of element
        By endOfElementSelector = By.cssSelector("a[href$='er.org'");
        driver.findElement(endOfElementSelector).click();
        TestUtils.sleep(2000);
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        System.out.println(endOfElementSelector);

        //looking by child first/last/third
        By firstEmotChild = By.cssSelector("li:first-child");
        By lastEmotChild = By.cssSelector("li:last-child");
        By thirdEmotChild = By.cssSelector("li:nth-child(3)");
        driver.findElement(firstEmotChild);
        driver.findElement(lastEmotChild);
        driver.findElement(thirdEmotChild);


        driver.quit();
    }
}
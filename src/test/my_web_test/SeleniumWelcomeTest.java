package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import java.util.List;

public class SeleniumWelcomeTest {
    // tests on a specially prepared website
    @Test
    public void SeleniumWelcomeTest() {
        WebDriverManager.chromedriver().setup();
        //Initialize Chrome options
        ChromeDriver driver = new ChromeDriver();
        driver.manage().
                window().
                maximize();
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");

        By cssID = By.cssSelector("#img1");
        driver.findElement(cssID); // finding selector

        By cssIDClickableButton = By.cssSelector("#testID1"); // 1 2 3 change to see if visible or not
        driver.findElement(cssIDClickableButton).click();

        WebElement ImageOneIsVisibleVerification = driver.findElement(By.cssSelector("img[alt='Obrazek 1"));

        if (ImageOneIsVisibleVerification.isDisplayed()) {
            System.out.println("Obrazek 1 is visible");
        } else {
            System.out.println("Obrazek 1 is not visible");
        }

        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator); // first input in code

        List<WebElement> inputs = driver.findElements(inputLocator);  // list of all imputs in code
        System.out.println(inputs.size());

        driver.findElement(By.cssSelector("body > button")).click();


        sleep();
        driver.quit();
    }


    public static void sleep() {
        try {
            Thread.sleep(2000); // 5000 milisekund = 5 sekund
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //ToDo tests WebDriverWait
    //ToDo seperate 2 tests or more
}



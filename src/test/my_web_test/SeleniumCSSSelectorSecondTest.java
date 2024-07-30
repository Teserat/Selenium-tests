package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumCSSSelectorSecondTest {

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
    public void test() {

        driver.findElement(By.cssSelector("#IDTestowaStrona1")).click();
        //div ul should give all vs div > ul only child
        //and like we see, it's not working

        By test1 = By.cssSelector("div ul");
        List<WebElement> elements1 = driver.findElements(test1);
        //TestUtils.printAllList(elements);
        System.out.println("Direct child <ul> elements inside <div>:");

        System.out.println("All <ul> elements inside <div>:");
        for (WebElement element : elements1) {
            System.out.println(element.getAttribute("class"));
        }

        System.out.println("\n-----------------------------------------------------------\n");

        By test2 = By.cssSelector("div > ul");
        List<WebElement> elements2 = driver.findElements(test2);
        //TestUtils.printAllList(elements2);

        System.out.println("Direct child <ul> elements inside <div>:");
        for (WebElement element : elements2) {
            System.out.println(element.getAttribute("class"));
        }

        /*
            ToDo find info why it happens or solution/fix // maybe test with other browser
        */
        TestUtils.sleep(1000);
        driver.quit();
    }
}

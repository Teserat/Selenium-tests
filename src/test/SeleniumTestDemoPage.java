import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumTestDemoPage {


    @Test
    public static void findSeleniumTutorial() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumdemo.com/");
        driver.findElement(By.xpath("//span[text()='Shop']")).click(); //span który ma tekst równy Shop
        WebElement seleniumProduct = driver.findElement(By.xpath("//h2[text()='Java Selenium WebDriver']"));    //znacznik h2, wewnątrz znacznika tekst który jest nazwą kursu "Java Selenium WebDriver"
        //Sprawdzenie czy element jest widoczny/wyswietlony
        Assert.assertTrue(seleniumProduct.isDisplayed());
        driver.quit();

    }
}

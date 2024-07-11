package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

public class SeleniumWelcomeTest {
    // testy na specjalnie przygotowanej stronie
    @Test
    public void SeleniumWelcomeTest() {
        WebDriverManager.chromedriver().setup();
        // Inicjalizacja Chrome options
        ChromeDriver driver = new ChromeDriver();
        driver.manage().
                window().
                maximize();
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");

        By cssID = By.cssSelector("#img1");
        driver.findElement(cssID);

        By cssIDClickableButton = By.cssSelector("#testID1");
        driver.findElement(cssIDClickableButton).click();

        WebElement ImageOneIsVisibleVerification = driver.findElement(By.cssSelector("img[alt='Obrazek 1"));

        if (ImageOneIsVisibleVerification.isDisplayed()){
            System.out.println("Obrazek 1 jest widoczny");
        }else {
            System.out.println("Obrazek 1 nie jest widoczny");
        }



        try {
            Thread.sleep(1000); // 5000 milisekund = 5 sekund
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    //ToDo tests WebDriverWait
}

package my_web_test;

import io.github.bonigarcia.wdm.WebDriverManager;
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
        driver.get("https://teserat.github.io/welcome/");

        driver.quit();
    }
}

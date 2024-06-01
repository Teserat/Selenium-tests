import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebSearch {

    @Test
    public void SeleniumWebSearch() {


        WebDriverManager.chromedriver().setup();
        // Inicjalizacja Chrome options
        ChromeDriver driver = new ChromeDriver();
        driver.manage().
                window().
                maximize();
        driver.get("https://www.google.com");
        // znalezienie przycisku
        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        // klikniecie przycisku
        agreeButton.click();
        // znajdz pole wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
        // wprowadz wartosc Selenium do pola
        searchField.sendKeys("Selenium");
        // zasymuluj nacisniecie przycisku Enter
        searchField.sendKeys(Keys.ENTER);
        // znalezc rezultat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));

        driver.quit();
    }

 //Assert.assertTrue(result.isDisplayed());
}

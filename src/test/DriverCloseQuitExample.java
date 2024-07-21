import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class DriverCloseQuitExample {


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://www.testeroprogramowania.pl', 'blank', 'height=300', 'width=400')");

        // Zamknięcie aktualnie aktywnej karty - zamyka pierwszą kartę (google) - pierwotną
        driver.close();

        // Zamknięcie całej przeglądarki wraz z wszystkimi kartami
        //driver.quit();
    }
}
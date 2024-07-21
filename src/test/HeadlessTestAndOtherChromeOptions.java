import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTestAndOtherChromeOptions {
    //test Headless, czyli nie wykorzystujemy zasobów na odpalanie przeglądarki która odpala się "pod spodem"

    @Test
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        // Inicjalizacja Chrome options
        ChromeOptions options = new ChromeOptions();

        // Ustawienie trybu headless
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        // Inicjalizacja WebDrivera z ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Przykład nawigacji do strony
        driver.get("https://www.example.com");

        // Zamknięcie przeglądarki
        driver.quit();
    }
    //inne zastosowania
//    options.addArguments("--start-maximized"); // Maksymalizacja okna przeglądarki
//    options.addArguments("--incognito"); // Tryb incognito
//    options.addArguments("--disable-popup-blocking"); // Wyłączenie blokowania wyskakujących okienek
//    options.addArguments("--disable-notifications"); // Wyłączenie powiadomień
//    options.addArguments("user-data-dir=/path/to/your/custom/profile"); // Użycie niestandardowego profilu użytkownika
//    options.addArguments("--window-size=1920,1080");
//    options.addArguments("--headless"); // Tryb headless
//
//    options.addArguments("--no-sandbox"); // Wyłączenie sandboxa (zalecane dla CI)
//    options.addArguments("--disable-dev-shm-usage"); // Zmniejszenie użycia /dev/shm (zalecane dla CI)
//    options.addArguments("--remote-debugging-port=9222"); // Umożliwienie zdalnego debugowania
//    options.addArguments("--lang=en"); // Ustawienie języka przeglądarki
//    options.addArguments("--disable-infobars"); // Wyłączenie infobars
//    options.addArguments("--disable-extensions"); // Wyłączenie rozszerzeń
//    options.addArguments("--disable-web-security"); // Wyłączenie zabezpieczeń sieciowych (niezalecane do użytku produkcyjnego)
//    options.addArguments("--allow-running-insecure-content"); // Zezwolenie na uruchamianie niezabezpieczonych treści
//    options.addArguments("--disable-features=VizDisplayCompositor"); // Wyłączenie niektórych funkcji (dla poprawy wydajności)
//    options.addArguments("--ignore-certificate-errors"); // Ignorowanie błędów certyfikatów
//    options.addArguments("--disable-software-rasterizer"); // Wyłączenie rastrowania programowego
//    options.addArguments("--disable-blink-features=AutomationControlled"); // Ukrycie, że przeglądarka jest kontrolowana przez automatyzację
//    options.addArguments("--enable-logging"); // Włączenie logowania
//    options.addArguments("--v=1"); // Ustawienie poziomu logowania
//    options.addArguments("--log-path=/path/to/logfile"); // Ścieżka do pliku logowania
}

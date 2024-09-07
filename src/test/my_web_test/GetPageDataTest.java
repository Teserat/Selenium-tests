package my_web_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetPageDataTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.initializeChromeDriver();
        //driver.get("http://127.0.0.1:5500/index.html"); //local host
        driver.get("https://teserat.github.io/welcome/");
    }
    @Test
    public void CheckWebsiteData(){
        System.out.println(driver.getTitle());
        //System.out.println(driver.getPageSource());
        System.out.println(driver.getCurrentUrl());
    }

    @AfterMethod
    public void onTestEnd() {
        TestUtils.sleep(800);
        driver.quit();
    }
}
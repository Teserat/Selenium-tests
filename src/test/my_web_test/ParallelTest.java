package my_web_test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ThreadLocalFactory;

//parallel test - in build // config and other things don't work here yet
// works only, when run from testng.xml

public class ParallelTest {
    @BeforeMethod
    public void setUp() {
        ThreadLocalFactory.setDriver();
    }

    @Test
    public void testOpenWelcomePage() {
        WebDriver driver = ThreadLocalFactory.getDriver();
        driver.get("https://teserat.github.io/welcome/");
        String title = driver.getTitle();
        System.out.println("Page Title for welcomepage: " + title);
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        Assert.assertTrue(title.contains("Zabawna Strona Internetowa"), "Title does not match!");
    }


    @Test
    public void testOpenHUB() {
        WebDriver driver = ThreadLocalFactory.getDriver();
        driver.get("https://teserat.github.io/welcome/hub");
        String title = driver.getTitle();
        System.out.println("Page Title for hub: " + title);
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        Assert.assertTrue(title.contains("Rozchodniak"), "Title does not match!");
    }

    @AfterMethod
    public void tearDown() {
        ThreadLocalFactory.removeDriver();
    }
}

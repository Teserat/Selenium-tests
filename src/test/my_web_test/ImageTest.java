package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HUBPage;
import pages.WelcomePage;

public class ImageTest extends BaseTest {

    @Test
    public void imageExistVerificationOnWelcomePage() {
        WebElement image = driver.findElement(By.tagName("img"));
        String imageHeight = image.getAttribute("naturalHeight");
        System.out.println(image.getAttribute("currentSrc"));
        System.out.println("Image height on welcome page : " + image.getAttribute("naturalHeight"));
        Assert.assertEquals("354", imageHeight);
        System.out.println(image.getAttribute("complete"));
    }

    @Test
    public void imageNotExistVerificationOnTestSide5() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide5MixElements2();
        WebElement image = driver.findElement(By.tagName("img"));
        System.out.println(image.getAttribute("currentSrc"));
        String imageHeight = image.getAttribute("naturalHeight");
        System.out.println("Image height on welcome page : " + image.getAttribute("naturalHeight"));
        Assert.assertEquals("0", imageHeight);
        System.out.println(image.getAttribute("complete"));
    }
}

package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageTest extends BaseTest{

    @Test
    public void imageExistVerificationOnWelcomePage() {
        WebElement image = driver.findElement(By.tagName("img"));
        String imageHeight = image.getAttribute( "naturalHeight");
        System.out.println(image.getAttribute("currentSrc"));
        System.out.println("Image height on welcome page : " + image.getAttribute( "naturalHeight"));
        Assert.assertEquals("354", imageHeight);
        System.out.println(image.getAttribute("complete"));
    }
    @Test
    public void imageNotExistVerificationOnTestSide5() {
        driver.findElement(By.linkText("Rozchodniak")).click();
        driver.findElement(By.linkText("TestSide5 - mix elements 2")).click();
        WebElement image = driver.findElement(By.tagName("img"));
        System.out.println(image.getAttribute("currentSrc"));
        String imageHeight = image.getAttribute( "naturalHeight");
        System.out.println("Image height on welcome page : " + image.getAttribute( "naturalHeight"));
        Assert.assertEquals("0", imageHeight);
        System.out.println(image.getAttribute("complete"));
    }
}

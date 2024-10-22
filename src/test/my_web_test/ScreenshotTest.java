package my_web_test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest extends BaseTest{

    @Test
    public void takesScreenshotTest() throws IOException {
        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide4 - uploading file"));
        System.out.println("Site : " + elementsPageLink.getText());
        elementsPageLink.click();

        //cast driver to TakeScreenshot and save screenshot to file
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String data = TestUtils.simpleDataStamp();
        String filename = "screenshot_" + data + ".png";
        FileUtils.copyFile(srcFile, new File("src/resources/" + filename));
    }
}

package my_web_test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.HUBPage;
import pages.WelcomePage;
import utils.TestUtils;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest extends BaseTest {

    @Test
    public void takesScreenshotTest() throws IOException {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide4UploadingFile();

        //cast driver to TakeScreenshot and save screenshot to file
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String data = TestUtils.simpleDataStamp();
        String filename = "screenshot_" + data + ".png";
        FileUtils.copyFile(srcFile, new File("src/resources/screenshots/" + filename));
    }
}

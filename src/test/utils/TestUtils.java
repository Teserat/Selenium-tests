package utils;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class TestUtils {

    private static WebDriver driver;

    public static void sleep(int sleepTimeInMillis) {
        try {
            Thread.sleep(sleepTimeInMillis); // 5000 miliseconds = 5 seconds

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printAllList(@NotNull List<WebElement> data) {
        // Print the text content of each item list webelement
        for (WebElement element : data) {
            String text = element.getText();
            System.out.println(text);
        }
    }

    //Check if text webelement is on select list of elements
    public static boolean checkSelectAssertion(String optionText, WebElement element) {
        Select select = new Select(element);
        //get all list
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(optionText))
                return true;
        }
        return false;
    }

    public static String dataStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
        String currentTime = sdf.format(new Date());
        return currentTime;
    }

    public static String simpleDataStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH_mm_ss_SSS");
        String currentTime = sdf.format(new Date());
        return currentTime;
    }

    public static void takeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String data = TestUtils.simpleDataStamp();
        String filename = "screenshot_" + data + ".png";
        FileUtils.copyFile(srcFile, new File("src/resources/screenshots/" + filename));
    }

    //--Explicit Wait
    public static void waitForElementToExist(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until((ExpectedConditions.presenceOfElementLocated(locator)));
    }
    //--Explicit Wait
    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until((ExpectedConditions.visibilityOf(element)));
    }
    //--Explicit Wait
    public static void waitForNotEmptyList(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(browser -> browser.findElements(locator).size() > 0);
    }
}

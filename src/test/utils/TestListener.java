package utils;

import my_web_test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    // start write on... to find specific methods

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        takeScreenshot(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //takeScreenshot(result);
    }

    //it won't work on some actions like alerts
    private void takeScreenshot(ITestResult result) {
        try {
            // download an instance of the test class and obtain the driver
            WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
            TestUtils.takeScreenshot(driver);  // Calling the screenshot method from TestUtils
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

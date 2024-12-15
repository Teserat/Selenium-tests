package my_web_test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HUBPage;
import pages.WelcomePage;

public class SoftAssertionsTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        WelcomePage welcomePage = new WelcomePage(driver);
        HUBPage hubPage = new HUBPage(driver);
        welcomePage.RozchodniakClick();
        hubPage.TestSide5MixElements2();
    }

    @Test
    public void verifyPageTitleWithSoftAssert() {

        //if broke 1 of 2 or both asserts, code will stop on end assertAll();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Strona testowa z wszystkimi elementami HTML";
        softAssert.assertEquals(actualTitle, expectedTitle, "Wrong web title!");
        System.out.println(driver.getCurrentUrl());
        softAssert.assertTrue(driver.getCurrentUrl().contains("welcome"), "URL not contains 'welcome'!");

        softAssert.assertAll();
    }
}

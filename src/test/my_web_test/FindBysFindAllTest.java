package my_web_test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CssSelectorPage;
import pages.HUBPage;
import pages.WelcomePage;


public class FindBysFindAllTest extends BaseTest {

    CssSelectorPage page;

    @BeforeMethod
    public void startPosition() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.RozchodniakClick();
        HUBPage hubPage = new HUBPage(driver);
        hubPage.TestSide1NestedElements();
        page = new CssSelectorPage(driver);
    }

    @Test
    public void testDirectChildItems() {
        System.out.println("Found items in allChildItems:");
        for (WebElement element : page.directChildItems) {
            System.out.println(" - " + element.getText());
        }
        Assert.assertEquals(page.directChildItems.size(), 2, "Direct Child Items count mismatch!");
        Assert.assertEquals(page.directChildItems.get(0).getText(), "Direct Child 1");
        Assert.assertEquals(page.directChildItems.get(1).getText(), "Direct Child 2");

    }

    @Test
    public void testNestedChildItems() {
        System.out.println("Found items in allChildItems:");
        for (WebElement element : page.nestedChildItems) {
            System.out.println(" - " + element.getText());
        }
        Assert.assertEquals(page.nestedChildItems.size(), 2, "Nested Child Items count mismatch!");
        Assert.assertEquals(page.nestedChildItems.get(0).getText(), "Nested Child 1");
        Assert.assertEquals(page.nestedChildItems.get(1).getText(), "Nested Child 2");
    }

    @Test
    public void testDeeplyNestedChildItems() {
        System.out.println("Found items in allChildItems:");
        for (WebElement element : page.deeplyNestedChildItems) {
            System.out.println(" - " + element.getText());
        }
        Assert.assertEquals(page.deeplyNestedChildItems.size(), 2, "Deeply Nested Child Items count mismatch!");
        Assert.assertEquals(page.deeplyNestedChildItems.get(0).getText(), "Deeply Nested Child 1");
        Assert.assertEquals(page.deeplyNestedChildItems.get(1).getText(), "Deeply Nested Child 2");
    }

    @Test
    public void testAllChildItems() {
        System.out.println("Found items in allChildItems:");
        for (WebElement element : page.allChildItems) {
            System.out.println(" - " + element.getText());
        }
        Assert.assertEquals(page.allChildItems.size(), 8, "Total Child Items count mismatch!");
    }
}

//ToDo check 2 of them, because 2 and 3 returns : Deeply Nested Child Items count mismatch!
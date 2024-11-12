package my_web_test;

import org.testng.annotations.Test;
import pages.HUBPage;
import pages.WelcomePage;

//  only for tests, before use to all others tests
public class ChildBaseTest extends BaseTest {

    @Test
    public void performActionRightMouseClick() {
        WelcomePage welcomePage = new WelcomePage(driver);
        HUBPage hubPage = new HUBPage(driver);

        welcomePage.RozchodniakClick();
        hubPage.TestSide2MixElementsClick();

        String pageTitle = driver.getTitle();
        System.out.println("Site " + pageTitle);
    }
}

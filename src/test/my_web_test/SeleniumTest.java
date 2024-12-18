package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

public class SeleniumTest extends BaseTest {

    @Test
    public void seleniumWelcomeTest() {

        By cssID = By.id("img1");  // by html element
        //By cssID = By.cssSelector("#img1");  // use a css selector to do the same with #
        driver.findElement(cssID); // finding selector in code for id (if its no selector, test fail)

        By firstName = By.name("firstName"); // by name attribute
        WebElement name = driver.findElement(firstName);
        By lastName = By.cssSelector("[name='lastName']"); // same by css selector
        WebElement surname = driver.findElement(lastName);

        By emotsList = By.className("emoticon-list"); //by class
        //By emotsList = By.cssSelector("[class=emoticon-list"); // same by css selector
        driver.findElement(emotsList);

        By link1 = By.linkText("Pixabay Playlists");
        By link2 = By.partialLinkText("Jango");
        driver.findElement(link1);
        driver.findElement(link2);

        By linkText = By.linkText("Pixabay Playlists");
        WebElement pixabayLink = driver.findElement(linkText);
        pixabayLink.click();
        String expectedTitle = "- Pixabay";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Wrong webside title");
        driver.navigate().back();

        By partialLink = By.partialLinkText("Jango");
        WebElement jangoLink = driver.findElement(partialLink);
        jangoLink.click();
        String expectedURL = "https://www.jango.com/browse_music/genre/Recommended";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Wrong URL address");
        //TestUtils.sleep(1000);
        driver.navigate().back();

        //-------------------------------------  test to split

        //save as WebElement object
        WebElement ImageOneIsVisibleVerification = driver.findElement(By.cssSelector("img[alt='Obrazek 1"));

        if (ImageOneIsVisibleVerification.isDisplayed()) {
            System.out.println("Obrazek 1 is visible"); // If button 1 is clicked then "Obrazek 1" is visible
        } else {
            System.out.println("Obrazek 1 is not visible");
        }

        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator); // first input in code

        List<WebElement> inputs = driver.findElements(inputLocator);  // list of all imputs in code
        System.out.println(inputs.size());

        driver.findElement(By.cssSelector("body > button")).click();

    }
}

//ToDo separate 2 tests or more



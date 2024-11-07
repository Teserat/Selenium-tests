package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverFactory;

public class HUBPage {

    WebDriver driver = WebDriverFactory.initializeChromeDriverHeadless();

    public HUBPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "TestSide2 - mix elements")
    private WebElement TestSide2MixElements;

    public void TestSide2MixElementsClick() {
        TestSide2MixElements.click();
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HUBPage {

    WebDriver driver;

    public HUBPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "TestSide1 - nested elements")
    private WebElement TestSide1NestedElements;

    @FindBy(linkText = "TestSide2 - mix elements")
    private WebElement TestSide2MixElements;


    @FindBy(linkText = "TestSide3 - newBrowser")
    private WebElement TestSide3NewBrowser;


    @FindBy(linkText = "TestSide4 - uploading file")
    private WebElement TestSide4UploadingFile;


    @FindBy(linkText = "TestSide5 - mix elements 2")
    private WebElement TestSide5MixElements2;


    @FindBy(linkText = "TestSide6 - Wait test")
    private WebElement TestSide6WaitTest;


    @FindBy(linkText = "TestSide7 - Okno Modalne")
    private WebElement TestSide7OknoModalne;


    public void TestSide1NestedElements() {
        TestSide1NestedElements.click();
    }
    public void TestSide2MixElementsClick() {
        TestSide2MixElements.click();
    }
    public void TestSide3NewBrowser() {
        TestSide3NewBrowser.click();
    }
    public void TestSide4UploadingFile() {
        TestSide4UploadingFile.click();
    }
    public void TestSide5MixElements2() {
        TestSide5MixElements2.click();
    }
    public void TestSide6WaitTest() {
        TestSide6WaitTest.click();
    }
    public void TestSide7OknoModalne() {
        TestSide7OknoModalne.click();
    }
}

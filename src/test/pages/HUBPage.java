package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger();

    public void TestSide1NestedElements() {
        logger.info("Go to: " + this.getClass().getSimpleName());
        TestSide1NestedElements.click();
        logger.info("Correct transition from: " + this.getClass().getSimpleName());
    }
    public void TestSide2MixElementsClick() {
        logger.info("Go to: " + this.getClass().getSimpleName());
        TestSide2MixElements.click();
        logger.info("Correct transition from: " + this.getClass().getSimpleName());
    }
    public void TestSide3NewBrowser() {
        logger.info("Go to: " + this.getClass().getSimpleName());
        TestSide3NewBrowser.click();
        logger.info("Correct transition from: " + this.getClass().getSimpleName());
    }
    public void TestSide4UploadingFile() {
        logger.info("Go to: " + this.getClass().getSimpleName());
        TestSide4UploadingFile.click();
        logger.info("Correct transition from: " + this.getClass().getSimpleName());
    }
    public void TestSide5MixElements2() {
        logger.info("Go to: " + this.getClass().getSimpleName());
        TestSide5MixElements2.click();
        logger.info("Correct transition from: " + this.getClass().getSimpleName());
    }
    public void TestSide6WaitTest() {
        logger.info("Go to: " + this.getClass().getSimpleName());
        TestSide6WaitTest.click();
        logger.info("Correct transition from: " + this.getClass().getSimpleName());
    }
    public void TestSide7OknoModalne() {
        logger.info("Go to: " + this.getClass().getSimpleName());
        TestSide7OknoModalne.click();
        logger.info("Correct transition from: " + this.getClass().getSimpleName());
    }
}

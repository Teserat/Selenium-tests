package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Rozchodniak")
    private WebElement Rozchodniak;

    private static final Logger logger = LogManager.getLogger();

    public void RozchodniakClick() {
        logger.info("Go to: " + this.getClass().getSimpleName());
        Rozchodniak.click();
        logger.info("Correct transition from: " + this.getClass().getSimpleName());
    }
}

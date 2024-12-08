package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CssSelectorPage {
    WebDriver driver;

    public CssSelectorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Finds all ul elements with class direct-child
    @FindBy(css = "ul.direct-child li")
    public List<WebElement> directChildItems;

    // Finds all ul elements with class nested-child
    @FindBy(css = "ul.nested-child li")
    public List<WebElement> nestedChildItems;

    // Finds elements that are nested deeply
    @FindBys({
            @FindBy(css = "div"),
            @FindBy(css = "ul.deeply-nested-child li")
    })
    public List<WebElement> deeplyNestedChildItems;

    // Finds elements that belong to any of the classes
    @FindAll({
            @FindBy(css = "ul.direct-child li"),
            @FindBy(css = "ul.nested-child li"),
            @FindBy(css = "ul.deeply-nested-child li")
    })
    public List<WebElement> allChildItems;
}

package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadFileTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = WebDriverFactory.initializeChromeDriver();
        driver.get("http://127.0.0.1:5500/index.html"); //local host
        //driver.get("https://teserat.github.io/welcome/");

        addFile("Test.txt");
    }

    @Test
    public void UploadFileTest() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide4 - uploading file"));
        elementsPageLink.click();

        //Converting a relative path to an absolute path:
        File file = new File("file.txt");
        String filePath = file.getAbsolutePath();
        //Test
        driver.findElement(By.id("myFile")).sendKeys(filePath);

    }

    @AfterMethod
    public void onTestEnd() {
        deleteFile();
        TestUtils.sleep(800);
        driver.quit();
    }

    //-Add method to add and delete file.
    private void addFile(String test) throws IOException {
        File file = new File("file.txt");
        if (file.createNewFile()) {
            System.out.println("Generated file");
        } else {
            System.out.println("File already exist");
        }
    }
    public static void deleteFile() {
        File file = new File("file.txt");

        if(file.delete()){
            System.out.println("File successfully deleted");
        }else{
            System.out.println("No file");
        }
    }


}


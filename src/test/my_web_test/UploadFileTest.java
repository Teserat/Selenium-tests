package my_web_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.io.File;
import java.io.IOException;

public class UploadFileTest extends BaseTest{

    @BeforeMethod
    public void setUp() throws IOException {
        addFile("Test.txt");
    }

    @Test
    public void UploadFileTest() {

        WebElement basicPageLink = driver.findElement(By.linkText("Rozchodniak"));
        basicPageLink.click();
        WebElement elementsPageLink = driver.findElement(By.linkText("TestSide4 - uploading file"));
        elementsPageLink.click();

        //Converting a relative path to an absolute path:
        String filename = "file.txt";
        File file = new File("src/resources/files/" + filename);
        String filePath = file.getAbsolutePath();
        //Test
        driver.findElement(By.id("myFile")).sendKeys(filePath);

    }

    @AfterTest
    public void DeleteFileAfterTest() {
        //TestUtils.sleep(1000);
        deleteFile();
    }

    //-Add method to add and delete file.
    private void addFile(String test) throws IOException {
        String filename = "file.txt";
        File file = new File("src/resources/files/" + filename);
        if (file.createNewFile()) {
            System.out.println("Generated file");
        } else {
            System.out.println("File already exist");
        }
    }
    public static void deleteFile() {
        String filename = "file.txt";
        File file = new File("src/resources/files/" + filename);

        if(file.delete()){
            System.out.println("File successfully deleted");
        }else{
            System.out.println("No file");
        }
    }

}


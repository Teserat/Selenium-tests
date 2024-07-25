package my_web_test;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TestUtils {


    public static void sleep(int sleepTimeInMillis) {
        try {
            Thread.sleep(sleepTimeInMillis); // 5000 miliseconds = 5 seconds

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printAllList(@NotNull List<WebElement> data) {
        // Print the text content of each item list webelement
        for (WebElement element : data) {
            String text = element.getText();
            System.out.println(text);
        }
    }

}

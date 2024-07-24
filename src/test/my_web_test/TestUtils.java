package my_web_test;

public class TestUtils {


    public static void sleep(int sleepTimeInMillis) {
        try {
            Thread.sleep(sleepTimeInMillis); // 5000 miliseconds = 5 seconds

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

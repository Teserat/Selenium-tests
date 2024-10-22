package my_web_test;

import org.testng.annotations.Test;

public class GetPageDataTest extends BaseTest{
    @Test
    public void CheckWebsiteData(){
        System.out.println(driver.getTitle());
        //System.out.println(driver.getPageSource());
        System.out.println(driver.getCurrentUrl());
    }
}
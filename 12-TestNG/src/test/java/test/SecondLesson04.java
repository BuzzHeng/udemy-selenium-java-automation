package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SecondLesson04 {
    @Test
    @Parameters({"URL"})
    public void WebLoginHomeLoan(String urlname){
        //Selenium
        System.out.println("Web Login Car");
        System.out.println(urlname);
    }

    @Test
    public void MobileLoginHomeLoan(){
        //Appium
        System.out.println("Mobile Login Car");
    }

    @Test
    public void LoginAPIHomeLoan(){
        //REST API Automation
        System.out.println("Login API Car");
    }
}

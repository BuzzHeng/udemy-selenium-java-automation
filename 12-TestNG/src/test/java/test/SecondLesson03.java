package test;

import org.testng.annotations.*;

public class SecondLesson03 {
    @BeforeClass
    public void BfClass(){
        System.out.println("Before execute any method in class");
    }
    @AfterClass
    public void AfClass(){
        System.out.println("After execute all method in class");
    }
    @Parameters({"URL"})
    @Test
    public void WebLoginCarLoan(String URL){
        //Selenium
        System.out.println("Web Login Car");
        System.out.println(URL);
    }

    @Test(groups="Smoke")
    public void MobileLoginCarLoan(){
        //Appium
        System.out.println("Mobile Login Car");
    }

    @BeforeSuite
    public void BFsuite(){
        System.out.println("I am No . 1");
    }

    @BeforeMethod
    public void BeforeEvery(){
        System.out.println("I will execute before every test method in SecondLesson03 class");
    }

    @AfterMethod
    public void AfterEvery(){
        System.out.println("I will execute after every test method in SecondLesson03 class");
    }

    @Test
    public void MobileSignInCarLoan(){
        //Appium
        System.out.println("Mobile Sign In Car");
    }
    @Test
    public void MobileSignOutCarLoan(){
        //Appium
        System.out.println("Mobile Sign Out Car");
    }
    @Test(dependsOnMethods = {"WebLoginCarLoan", "MobileSignOutCarLoan"})
    public void APICarLoan(){
        //REST API Automation
        System.out.println("Login API Car");
    }
}

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
    @Parameters({"URL","APIKEY/username"})
    @Test
    public void WebLoginCarLoan(String URL, String key){
        //Selenium
        System.out.println("Web Login Car");
        System.out.println(URL);
        System.out.println(key);
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
    @Test(dataProvider = "getData")
    public void MobileSignOutCarLoan(String username, String password){
        //Appium
        System.out.println("Mobile Sign Out Car");
        System.out.println(username);
        System.out.println(password);
    }
    @Test(dependsOnMethods = {"WebLoginCarLoan", "MobileSignOutCarLoan"})
    public void APICarLoan(){
        //REST API Automation
        System.out.println("Login API Car");
    }

    @DataProvider
    public Object[][] getData(){
        // 1st Combination - username password - good credit history
        // 2nd Combination - username password - no credit history
        // 3rd Combination - Fraud credit history

        //multi dimensional object array
        Object[][] data = new Object[3][2]; // 3 row 2 column

        //1st Set
        data[0][0] = "firstsetusername";
        data[0][1] = "password";
        //col in row are nothing but values for that particular combination(row)
        //2nd Set
        data[1][0] = "secondsetusername";
        data[1][1] = "secondpassword";
        //3rd Set
        data[2][0] = "thirdsetusername";
        data[2][1] = "thirdpassword";
        return data;
    }
}

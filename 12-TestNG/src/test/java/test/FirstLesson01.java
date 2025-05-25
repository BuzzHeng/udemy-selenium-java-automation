package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstLesson01{

    @AfterSuite
    public void AFSuite(){
        System.out.println("I am No. 1 from last");
    }
    @AfterTest
    public void lastExecution(){
        System.out.println("I will execute last");
    }
    @Test
    @Parameters({"URL"})
    public void FirstTest(String urlname){
        System.out.println("Hello");
        System.out.println(urlname);
        Assert.fail();
    }

    @Test(groups="Smoke")
    public void SecondTest(){
        System.out.println("Bye");
    }


}

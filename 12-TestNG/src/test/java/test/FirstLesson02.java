package test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstLesson02 {
    @Test(groups="Smoke")
    public void Ploan(){
        System.out.println("Good");
    }

    @BeforeTest
    public void prerequisite(){
        System.out.println("I will execute first!");
    }
}

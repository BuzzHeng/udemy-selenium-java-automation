import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PS {

    @BeforeMethod
    public void BeforeTest(){
        System.out.println("Run me first");
    }

    public void doThis() {
        System.out.println("I am here");
    }
}

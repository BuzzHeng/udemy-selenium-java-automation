import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\leeyu\\Github\\Udemy\\udemy-selenium-java-automation\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   //implicit wait
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //<input type="text" placeholder="Username" id="inputUsername" value="">
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");

        //<button class="submit signInBtn" type="submit">Sign In</button>
        //When see space in class attribute -> 2 classes
        driver.findElement(By.className("signInBtn")).click();

        // CSS Selector-
        // Class name -> tagname.classname          -> Button.signInBtn
        //         Id -> tagname#id                 -> input#inputUsername

        //<input type="text" placeholder="Username" value="">
        //            -> Tagname[attribute='value'] -> Input[placeholder='Username']

        //<p class="error">* Incorrect username or password </p>

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        // Confirm unique css/ xapth by using SelectorsHub/ChroPath or Developer Tool Console
        // Syntax $('p.error')
    }
}

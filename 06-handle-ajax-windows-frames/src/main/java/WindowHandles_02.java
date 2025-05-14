import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles_02 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector(".blinkingText")).click();

        // Use Set to get window handles
        Set<String> windows = driver.getWindowHandles();    //[parentID, childID]
        // Use Iterator to store parentId child ID
        Iterator<String> it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

        // Use debug and watch to evaluate expression to get email from text
        String emailID = driver.findElement(By.cssSelector(".im-para.red"))
                .getText().split("at")[1].split(" ")[1];

        driver.switchTo().window(parentID);
        driver.findElement(By.id("username")).sendKeys(emailID);



    }
}

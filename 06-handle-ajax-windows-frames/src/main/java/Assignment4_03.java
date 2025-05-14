import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment4_03 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.cssSelector("a[href*='windows']")).click();

        Set<String> window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String parentID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
    }
}

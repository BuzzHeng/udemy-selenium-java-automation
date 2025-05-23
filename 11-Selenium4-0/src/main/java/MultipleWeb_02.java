import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class MultipleWeb_02 {
    public static void main(String[] args) throws IOException {

        //Scenario
        //Navigate to 1st URL
        //Fill "Name" field with first course name available at 2nd URL
        //https://rahulshettyacademy.com

        //Key Step switchTo() new window, get parentWindowID, childWindowID
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // 02 Switching Window
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindowID = it.next();
        String childWindowID = it.next();
        driver.switchTo().window(childWindowID);
        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']"))
                .get(1).getText();
        driver.switchTo().window(parentWindowID);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));

        // 03 WebElement Screenshot
        name.sendKeys(courseName);
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));

        // 04 Get height width of web element
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.time.Duration;
import java.util.List;

public class ConsoleLogsCapture {
    public static void main(String[] args){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        // inTestNG, Listeners - OnTestfailure
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.partialLinkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
        // Fail go to Test Listener
        LogEntries entry = driver.manage().logs().get(LogType.BROWSER); //Get LogEntries object
        List<LogEntry> logs = entry.getAll(); //Logentryobject - getAll method return all logs in list

        for(LogEntry e : logs){ //Iterating through list and print each log message.
           System.out.println(e.getMessage());
        }
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8_05 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        Thread.sleep(1000);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.id("autocomplete")).getDomProperty("value"));
    }
}

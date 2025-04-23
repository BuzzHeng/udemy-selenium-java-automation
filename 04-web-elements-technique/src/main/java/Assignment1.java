import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("Heng");
        driver.findElement(By.name("email")).sendKeys("123@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("examplepassword");
        driver.findElement(By.id("exampleCheck1")).click();

        WebElement dropdownElement = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Female");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("23/07/1992");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        System.out.println(driver.findElement(By.className("alert-success")).getText());
    }
}

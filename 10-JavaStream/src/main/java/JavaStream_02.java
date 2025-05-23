import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JavaStream_02 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Click on Column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        // Capture all WebElement into list
        List<WebElement> colFirst = driver.findElements(By.xpath("//tr/td[1]"));

        // Capture text of all element into new list
        List<String> nameList = colFirst.stream().map(s->s.getText()).toList();

        // Sort in the original list of step 3 -> sorted list
        List<String> sortedList = nameList.stream().sorted().toList();

        // Compare original list vs sorted list
        Assert.assertTrue(nameList.equals(sortedList));
    }
}

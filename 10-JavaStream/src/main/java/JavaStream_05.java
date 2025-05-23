import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JavaStream_05 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys("Rice");
        List<WebElement> veggiesElement = driver.findElements(By.xpath("//tr/td[1]"));
        //5 result in veggiesElement
        List<WebElement> filteredList = veggiesElement.stream()
                .filter(s->s.getText().contains("Rice"))
                .toList();
        //1 result in filteredList
        Assert.assertEquals(veggiesElement.size(), filteredList.size());
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;


public class JavaScriptExecutor_01 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> value = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int totalSum = 0;
        for(int i=0; i<value.size();i++){
            System.out.println(value.get(i).getText());
            totalSum += Integer.parseInt(value.get(i).getText());
        }
        System.out.println(totalSum);
        int totalAmount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(totalSum,totalAmount);

    }
}

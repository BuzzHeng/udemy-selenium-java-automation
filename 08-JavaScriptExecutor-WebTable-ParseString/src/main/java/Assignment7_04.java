import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment7_04{
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement table = driver.findElement(By.id("product"));

        System.out.println(table.findElements(By.tagName("tr")).size());
        System.out.println(table.findElements(
                By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

        // By tagName
        System.out.println("By tagName:");
        List<WebElement> secondRow = table.findElements(
                By.tagName("tr")).get(2).findElements(By.tagName("td"));
        System.out.println(secondRow.get(0).getText());
        System.out.println(secondRow.get(1).getText());
        System.out.println(secondRow.get(2).getText());

        // By css Selector
        System.out.println("By Css Selector:");
        List<WebElement> rowSecond = table.findElements(By.cssSelector("tr:nth-child(3) td"));
        System.out.println(rowSecond.get(0).getText());
        System.out.println(rowSecond.get(1).getText());
        System.out.println(rowSecond.get(2).getText());
    }
}

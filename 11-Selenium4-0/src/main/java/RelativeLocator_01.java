import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocator_01 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameEditBox = driver.findElement(By.cssSelector("input[name='name']"));

        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        //Part 2
        // Flex component will skip.
        WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateOfBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
        WebElement iceCreamLabel = driver.findElement(
                By.xpath("//label[text()='Check me out of you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

        WebElement rdb = driver.findElement(By.id("inlineRadio"));
        driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText();
    }
}

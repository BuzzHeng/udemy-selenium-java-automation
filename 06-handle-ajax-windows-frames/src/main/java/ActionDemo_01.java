import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionDemo_01 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        //Manual enter CAPCHT within 10s.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions a = new Actions(driver);

        WebElement accountList = driver.findElement(By.cssSelector("div[id='nav-link-accountList']"));
        WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));

        a.moveToElement(searchTextBox)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("hello")
                .doubleClick()
                .build().perform();

        //Move to specific element, right click using .contextClick()
        a.moveToElement(accountList).contextClick().build().perform();

    }
}

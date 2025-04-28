import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class HandlingCheckBox_05 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertFalse(driver.findElement
                (By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());

        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement
                (By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement
                (By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        driver.findElement(By.id("divpaxinfo")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class UpdateDropDown_06 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        //xpath indexes
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //xpath parent child relationship
        driver.findElement(By.xpath(
                        "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
                .click();

        // ui-state-default.ui-state-active, how to select calandar current date.
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
    }
}

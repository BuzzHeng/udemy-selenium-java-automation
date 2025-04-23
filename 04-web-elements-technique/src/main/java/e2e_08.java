import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class e2e_08 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement fromLocation = driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT"));
        WebElement seniorChkbox = driver.findElement(By.cssSelector(
                "input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']"));

        //Click round trip
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        fromLocation.click();
        // Click From location
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        //Click To location
        driver.findElement(By.xpath(
                "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        //Current Date
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        //Validate Return date is not selected
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
        {
            System.out.println("its disabled");
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
        seniorChkbox.click();

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for(int i=1; i<5; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        //Search flight
        //driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']"))
        //driver.findElement(By.xpath("//inpuT[@value='Search']")).click();
        //driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
        driver.findElement(By.cssSelector("input[value='Search']")).click();



    }
}

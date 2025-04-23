import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UpdateDropDown_02 {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.phptravels.net/flights");
        // Apply implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement dropdownBtnTraveller = driver.findElement(By.xpath(
                "//a[@class='dropdown-toggle dropdown-btn travellers waves-effect']"));

        dropdownBtnTraveller.click();
        int i = 1;
        while(i<5){
            driver.findElements(By.className("qtyInc")).get(0).click();
            i++;
        }
        /* For loop
        for(int i = 1;i<5;i++){
            driver.findElements(By.className("qtyInc")).get(0).click();
        }
        */
        dropdownBtnTraveller.click();
        System.out.println(dropdownBtnTraveller.getText());
    }
}

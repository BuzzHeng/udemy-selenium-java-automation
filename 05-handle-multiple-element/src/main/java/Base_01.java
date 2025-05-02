import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Base_01 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise");

        String[] itemNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
        int itemFoundCounter = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            // Format it to get actual vegetable name
            //Brocoli - 1kg, Format by hyphen
            String[] name = products.get(i).getText().split("-");
            //name[0] - Brocoli, name[1] - 1 kg
            String formattedName = name[0].trim();

            // Check whether name you extract is present in the array
            // Convert Array into ArrayList for easy Search
            List<String> itemNeededList = Arrays.asList(itemNeeded);


            if (itemNeededList.contains(formattedName)) {
                itemFoundCounter++;
                //Click on Add to Cart
                // Bad practice to use text as it can be change dynamically
                //driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (itemFoundCounter == itemNeeded.length) {
                    break;
                }
            }
        }
    }
}

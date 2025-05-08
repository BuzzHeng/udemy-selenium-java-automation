import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base_02 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        // Implicit Wait, timeout duration for all WebElement globally.
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Explicit Wait
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        String[] itemNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
        addItem(driver,itemNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        driver.findElement(By.xpath("//div[@class='cart-preview active']//button[@type='button']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //Explicit Wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

    }

    public static void addItem(WebDriver driver, String[] itemNeeded){
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



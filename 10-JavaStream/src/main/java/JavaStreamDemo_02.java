import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamDemo_02 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Click on Column
        driver.findElement(By.xpath("//tr/th[1]")).click();
        // Capture all webelement into list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        // Capture text of all element into new list
        List<String> originalList = elementsList.stream().map(WebElement::getText).toList();

        // Sort in the original list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().toList();

        // Compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));

        // Scan the name column with getText -> s -> print price of the Rice
        // Custom method
        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));

            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (price.size() < 1);
    }

    private static String getPriceVeggie(WebElement s){
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}


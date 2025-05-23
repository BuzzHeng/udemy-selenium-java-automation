import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JavaStream_04 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Click on Column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        // Capture all WebElement into list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

        // Capture text of all element into new list
        List<String> nameList = elementList.stream().map(s->s.getText()).toList();

        // Sort in the original list of step 3 -> sorted list
        List<String> sortedList = nameList.stream().sorted().toList();

        // Compare original list vs sorted list
        Assert.assertTrue(nameList.equals(sortedList));

        //Scan the name column with getText -> Rice -> print price of rice.
        List<String> price;
        do{
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
             price = rows.stream()
                    .filter(s->s.getText().contains("Rice"))
                    .map(s->getPriceVeggie(s))
                    .toList();
            price.forEach(System.out::println);
            if(price.isEmpty()){
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }
        }while(price.isEmpty());

    }

    private static String getPriceVeggie(WebElement s){
        String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }
}

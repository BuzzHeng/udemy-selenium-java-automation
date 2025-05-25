import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class Practice06 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Click on Column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //Capture veg/fruit name to list
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
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        } while (price.isEmpty());

    }
    
    public static String getPriceVeggie(WebElement s){
        String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }
}

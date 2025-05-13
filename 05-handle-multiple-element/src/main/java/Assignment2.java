import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment2 {
    public static void main(String[] args){

        // Disable password manager
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // Run in incognito mode
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String username = "rahulshettyacademy";
        String password = "learning";

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement okayBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        okayBtn.click();

        //Handle static dropdown box
        WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select userDropdown = new Select(staticDropdown);
        userDropdown.selectByVisibleText("Consultant");
        Assert.assertEquals(userDropdown.getFirstSelectedOption().getText(), "Consultant");

        //Checkbox terms agreement
        driver.findElement(By.id("terms")).click();
        Assert.assertTrue(driver.findElement(By.id("terms")).isSelected());

        driver.findElement(By.id("signInBtn")).click();

        List<WebElement> products = wait.until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card-footer .btn-info")));

        Assert.assertEquals(products.size(),4);

        for(int i=0; i<products.size();i++){
            products.get(i).click();
        }

        //Checkout
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}

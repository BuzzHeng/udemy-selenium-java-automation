import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverManageOptions_02 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // driver.manage().deleteCookieNamed("sessionKey");
        // Click on any link
        // Login page verify login url
        driver.get("https://google.com");
    }
}

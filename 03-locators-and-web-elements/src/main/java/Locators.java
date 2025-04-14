import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver path
       //System.setProperty("webdriver.chrome.driver",
       //         "C:\\Users\\leeyu\\Github\\Udemy\\udemy-selenium-java-automation\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Apply implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Open test page
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // 🔹 Fill in login fields
        // <input type="text" placeholder="Username" id="inputUsername">
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");

        // <input name="inputPassword" type="password">
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");

        // <button class="submit signInBtn">Sign In</button>
        // When class has space → multiple classes → use only one (e.g. "signInBtn")
        driver.findElement(By.className("signInBtn")).click();

        // 🔹 CSS Selectors Examples
        // Class      → tagname.classname            → button.signInBtn
        // ID         → tagname#id                   → input#inputUsername
        // Attribute  → tagname[attr='value']        → input[placeholder='Username']

        // <p class="error">* Incorrect username or password </p>
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        // Confirm selectors using:
        // DevTools Console → $('p.error') for CSS
        //                   → $x('//input[@placeholder="Name"]') for XPath

        // 🔹 Navigate to reset password page
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000); // Explicit wait

        // 🔹 Fill reset form
        // XPath: //tagname[@attribute='value']
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Lee");
        // CSS attribute selector
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("leeyuanheng16@rsa.com");
        // XPath with index: [2] selects the second matching node
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        // CSS nth-child selector (indexing starts from parent)
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("leeyuanheng16@gmail.com");

        // 🔹 Indexing Notes
        // XPath:      //tagname[@attr='val'][index]
        // CSS:        tagname[attr='val']:nth-child(index)

        // 🔹 Parent to Child Traversing
        // XPath:      //form/input[3]
        // CSS:        form input
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("12345677");

        // Submit reset form
        driver.findElement(By.className("reset-pwd-btn")).click();

        // Extract confirmation text
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
    }
}

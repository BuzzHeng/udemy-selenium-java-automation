package rahulshettyacademy.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahulshettyacademy.pageObjects.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                + "\\14-FrameWork\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");
        System.out.println("Browser: " + browserName);

        if (browserName.equalsIgnoreCase("chrome")) {
            System.out.println("Launching Chrome...");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.out.println("Launching Firefox...");
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.out.println("Launching Edge...");
            System.setProperty("webdriver.edge.driver", "edge.exe");
            driver = new EdgeDriver();
        }

        if (driver == null) {
            throw new IllegalStateException("Driver is null. Check 'browser' value or WebDriver setup.");
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public LoginPage launchApplication() throws IOException{
        driver = initializeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");
        return loginPage;
    }

}

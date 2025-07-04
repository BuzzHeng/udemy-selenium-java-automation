package rahulshettyacademy.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import rahulshettyacademy.pageObjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landingPage;

    public WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                + "\\14-FrameWork\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
        prop.load(fis);

        // Ternary operator to get argument from maven command or GlobalData.properties
        // If 1st condition true, run 2nd condition else run 3rd condition.
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
        System.out.println("Browser: " + browserName);

        if (browserName.toLowerCase().contains("chrome")) {
            System.out.println("Launching Chrome...");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if(browserName.contains("headless")){
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1440,900");
                options.addArguments("--disable-gpu");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.toLowerCase().contains("firefox")) {
            System.out.println("Launching Firefox...");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.toLowerCase().contains("edge")) {
            System.out.println("Launching Edge...");
            System.setProperty("webdriver.edge.driver", "edge.exe");
            driver = new EdgeDriver();
        }

        if (driver == null) {
            throw new IllegalStateException("Driver is null. Check 'browser' value or WebDriver setup.");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (!browserName.toLowerCase().contains("headless")) {
            driver.manage().window().maximize();
        }
        System.out.println("Viewport size: " + driver.manage().window().getSize());
        return driver;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
        //read json to string
        String jsonContent = FileUtils.readFileToString(new File(filepath));

        //Convert string to hashmap Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<>() {
        });
        return data;
        //{map, map}
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException{
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");
        return landingPage;
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

}

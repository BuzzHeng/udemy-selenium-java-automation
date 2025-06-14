package rahulshettyacademy.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import rahulshettyacademy.pageObjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

    public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
        //read json to string
        String jsonContent = FileUtils.readFileToString(new File(filepath));

        //Convert string to hashmap Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
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

    
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

}

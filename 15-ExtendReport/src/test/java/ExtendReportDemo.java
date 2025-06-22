import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtendReportDemo {
    ExtentReports extent;

    @BeforeTest
    public void config(){
        // ExtendReports, ExtentSparkReporter
        // ExtentSparkReporter - Responsible for creating report
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        //ExtendReports
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Rahul Shetty");
    }

    @Test
    public void initialDemo(){
        ExtentTest test = extent.createTest("Initial demo");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\leeyu\\Github\\Udemy\\udemy-selenium-java-automation\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.close();
        //Mark as fail to show difference
        test.fail("Result do not match");
        extent.flush();
    }
}

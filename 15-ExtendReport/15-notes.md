[ ExtendReports ]
1) Basic Configuration with StandAloneTest
- ExtendSparkReporter - Responsible for HTML Report File
- ExtentReports - Main class to aggregate and manage tests
- ExtentTest - Individual test log entry
```java
public class ExtendReportDemo {
    ExtentReports extent;

    @BeforeTest
    public void config(){
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
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
        test.fail("Result do not match"); //Mark as fail to show difference
        extent.flush();
    }
}
 ```

2) Generate Report for Parallel Test Execution
3) Attach Screenshot to Reports for failed Tests using TestNG Listener
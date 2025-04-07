import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntro {
    public static void main(String[] args) {

        // 🔹 Flag to control manual vs automatic driver setup
        boolean useManualSetup = false;

        // 🔹 Choose the browser to test (chrome, firefox, edge)
        String browser = "chrome";

        // 🔹 Manual Driver Setup (only if useManualSetup = true)
        if (useManualSetup) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        "C:\\Path\\To\\chromedriver");
            } else if (browser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver",
                        "C:\\Path\\To\\msedgedriver");
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver",
                        "C:\\Path\\To\\geckodriver");
                // Firefox usually works without manual path due to Selenium Manager
            }
        }

        // 🔹 Initialize WebDriver based on chosen browser
        WebDriver driver = switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver(); // Uses Selenium Manager or manual path
            case "firefox" -> new FirefoxDriver(); // Uses Selenium Manager
            case "edge" -> new EdgeDriver(); // Uses Selenium Manager or manual path
            default -> throw new RuntimeException("Browser not supported: " + browser);
        };

        // 🔹 Sample browser actions
        driver.get("https://www.google.com"); // Open URL
        System.out.println("Title: " + driver.getTitle()); // Print page title
        System.out.println("URL: " + driver.getCurrentUrl()); // Print current URL

            // 🔹 Close browser
        driver.close(); // Closes the current tab (or window) only
        driver.quit();  // Closes all browser windows opened by the driver and ends the session
    }
}

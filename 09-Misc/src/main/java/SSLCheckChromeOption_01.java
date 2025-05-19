import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class SSLCheckChromeOption_01 {
    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        //Special case a website, need proxy to access
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddres:4444");
        options.setCapability("proxy",proxy);

        //Example, Set Download Directory
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com");
        System.out.println(driver.getTitle());
    }
}

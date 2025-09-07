import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.emulation.Emulation;

import java.util.HashMap;
import java.util.Map;

public class SetGeoLocation {
    public static void main(String[] args){

        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String,Object> coordinates = new HashMap<String,Object>();
        coordinates.put("latitude", 40);
        coordinates.put("longitude", 3);
        coordinates.put("accuracy",1);

        //executeCdpCommand
        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        driver.get("http:/google.com");
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
        String title = driver.findElement(By.cssSelector(".default-ltr-iqcdef-cache-4b5q1b.euy28770")).getText();
        System.out.println(title);
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class BrokenLinks_03 {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Broken URL
        // Java method will call url and get you the status code
        // Step 1 - get all URLs tied up to the link with Selenium
        // Step 2 - If status code > 400 then that url is not working.


        //Deprecated
        //String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getDomAttribute("href");
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        //Soft Assertion
        SoftAssert a = new SoftAssert();

        for (WebElement link: links){
            String url = link.getDomProperty("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();

            //using Soft Assertion
            a.assertTrue(respCode<400, "The link with text " + link.getText()+ " is broken with code " + respCode);

            /*
            if(respCode>400){
                System.out.println("The link with text " + link.getText()+ " is broken with code " + respCode);
                Assert.fail(); //Hard Assertion
            }*/
        }

        // Modern Alternative
        String url2 = driver.findElement(By.cssSelector("a[href*='soapui']")).getDomAttribute("href");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url2))
                .method("HEAD",HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
        System.out.println("Status code: " + response.statusCode());

        a.assertAll();
    }
}

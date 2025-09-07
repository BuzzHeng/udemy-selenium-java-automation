import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.fetch.Fetch;
import org.openqa.selenium.devtools.v137.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v137.network.model.ErrorReason;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NetworkFailedRequest {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Fetch.enable
        // Enables issuing of requestPaused events.
        // A request paused until client calls one of failRequest, fulfillRequest or continueRequest/continueWithAuth.

        //Optional<String> urlPattern, Optional<ResourceType> resourceType, Optional<RequestStage> requestStage
        Optional<List<RequestPattern>> pattern = Optional.of(List.of(new RequestPattern(Optional.of("GetBook"), Optional.empty(), Optional.empty())));
        devTools.send(Fetch.enable(pattern, Optional.empty()));

        // Always addListerner for selenium to listen when this event happen
        devTools.addListener(Fetch.requestPaused(),request->
        {
            devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library'")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector("p")).getText());
    }
}

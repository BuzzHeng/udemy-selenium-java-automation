import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.network.Network;
import org.openqa.selenium.devtools.v137.network.model.Request;
import org.openqa.selenium.devtools.v137.network.model.Response;

import java.util.Optional;

public class NetworkLogActivity {
    public static void main(String[] args){
        ChromeDriver driver = new ChromeDriver();

        //https://chromedevtools.github.io/devtools-protocol/tot/Network/
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));

        // Get Network request
        devTools.addListener(Network.requestWillBeSent(), request->
        {
            Request req = request.getRequest();
            System.out.println("Req Url: " + req.getUrl());
            System.out.println("Req header: " + req.getHeaders());
        });

        //Event will get fired, add listener for response received
        // Get Network reponse
        devTools.addListener(Network.responseReceived(), response->
        {
            Response res = response.getResponse();
            System.out.println("Res Url: "+res.getUrl());
            System.out.println("Res Status: " + res.getStatus());
            if (res.getStatus().toString().startsWith("4")){
               System.out.println(res.getUrl() + "is failing with status code" + res.getStatus());
            }
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

    }
}

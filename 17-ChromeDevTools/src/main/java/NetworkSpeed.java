import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.network.Network;
import org.openqa.selenium.devtools.v137.network.model.ConnectionType;
import org.openqa.selenium.devtools.v137.network.model.TimeSinceEpoch;

import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class NetworkSpeed {
    public static void main(String[] args) throws Exception {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        DevToolsTimeConverter converter = new DevToolsTimeConverter();

        // Enable Network events
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Throttle while staying ONLINE (offline=false). Adjust as needed.
        devTools.send(Network.emulateNetworkConditions(
                true,                // keep online; true would force offline
                3000,                 // latency ms
                20_000,               // download bytes/sec  (~160 kbps)
                100_000,              // upload bytes/sec    (~800 kbps)
                Optional.of(ConnectionType.CELLULAR2G),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        // Capture offset once: requestWillBeSent has wallTime (UTC) + timestamp (monotonic)
        devTools.addListener(Network.requestWillBeSent(), e -> {
            Optional<TimeSinceEpoch> wallOpt = Optional.ofNullable(e.getWallTime());
            if (wallOpt.isPresent() && !converter.isReady()) {
                converter.captureOffset(wallOpt.get(), e.getTimestamp());
            }
        });

        // For demo: wait for at least one failure event to print
        CountDownLatch firstFailure = new CountDownLatch(1);

        // Convert monotonic -> wall clock inside the listener
        devTools.addListener(Network.loadingFailed(), loadingFailed -> {
            System.out.println("Error: " + loadingFailed.getErrorText());
            if (converter.isReady()) {
                // You can print Date, Instant, or ZonedDateTime (e.g., Asia/Singapore)
                Date wall = converter.toDate(loadingFailed.getTimestamp());
                System.out.println("Wall clock: " + wall);
                // Or ISO-8601 in Singapore:
                System.out.println("Wall clock (SGT ISO): " +
                        converter.toZoned(loadingFailed.getTimestamp(), ZoneId.of("Asia/Singapore")));
            } else {
                // Offset not yet captured; print raw monotonic seconds
                System.out.println("Monotonic seconds: " +
                        loadingFailed.getTimestamp().toJson().doubleValue() + " (offset not ready)");
            }
            firstFailure.countDown();
        });

        long startTime = System.currentTimeMillis();
        try {
            driver.get("https://rahulshettyacademy.com/angularAppdemo/");
            // Note: closing bracket in selector
            driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken (ms): " + (endTime - startTime));

            // Give DevTools listeners time to flush logs (optional)
            firstFailure.await(5, TimeUnit.SECONDS);
        } finally {
            driver.quit();
        }
    }
}

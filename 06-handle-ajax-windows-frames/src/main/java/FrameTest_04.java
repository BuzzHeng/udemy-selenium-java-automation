import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest_04 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        //driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        //driver.switchTo().frame(1);

        int frameCount = driver.findElements(By.tagName("iframe")).size();
        System.out.printf("Number of frame: %d%n",frameCount); // To find number of frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

        Actions a = new Actions(driver);
        //driver.findElement(By.id("draggable")).click();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source,target).build().perform();
        driver.switchTo().defaultContent();
    }
}

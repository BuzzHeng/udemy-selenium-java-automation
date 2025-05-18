    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;

    import java.util.Iterator;
    import java.util.Set;

    import static org.openqa.selenium.Keys.chord;

    public class LinkValidation_Exercise_01 {
        public static void main(String[] args){
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            //1. Find count of link in URL
            System.out.println(driver.findElements(By.tagName("a")).size());

            //2. Find count of link in URL Footer.
            WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //Limiting WebDriver scope
            System.out.println(footerDriver.findElements(By.tagName("a")).size());

            //3. Find count of link in a specific column.
            WebElement columnFooterDriver = footerDriver.findElement(
                    By.xpath("//table/tbody/tr/td[1]/ul"));
            System.out.println(columnFooterDriver.findElements(By.tagName("a")).size());

            int linkSize = columnFooterDriver.findElements(By.tagName("a")).size();

            //4. Click on each link in column and check if page are opening
            for(int i=1; i < linkSize; i++){
                String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
                columnFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            }

            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> it  = windowHandles.iterator();

            while(it.hasNext()){
                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());
            }
        }
    }

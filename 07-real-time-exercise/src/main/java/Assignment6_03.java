import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class Assignment6_03 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1. Select Any Checkbox
        //2. Grab the label of the checkbox //put into variable
        //3. Select an option in dropdown. Here option to select should come from step 2.
        //   Do not hard code. it should be dynamically from step 2.
        //4. Enter the step 2 grabbed label text in Editbox //
        //5. Click Alert and then verify if text grabbed from step 2 is present in the pop up message
        // Do not hardcode label part.

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.id("checkBoxOption2")).click();
        System.out.println(driver.findElement(By.id("checkBoxOption2")).getText());

        String label = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText().trim();
        System.out.println("Check Box Label: " + label);

        WebElement dropDownBox = driver.findElement(By.cssSelector("select[id='dropdown-class-example']"));
        Select selectDropDownBox = new Select(dropDownBox);
        selectDropDownBox.selectByVisibleText(label);

        String selectedText = selectDropDownBox.getFirstSelectedOption().getText();
        System.out.println(selectedText);

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(selectedText);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        String getAlertText = driver.switchTo().alert().getText();
        System.out.println(getAlertText);
        Assert.assertTrue(getAlertText.contains(label));
        driver.switchTo().alert().dismiss();
    }
}

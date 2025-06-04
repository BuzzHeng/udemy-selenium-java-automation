package rahulshettyacademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {

    WebDriver driver;

    //Constructor
    //Required to pass driver from test to this page.
    public LoginPage(WebDriver driver){
        //Initialization
        super(driver);
        this.driver = driver;

        //PageFactory Design Pattern, Initialize all method
        //'this' refer to current driver.
        PageFactory.initElements(driver, this);
    }

    /*  Usual way
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        WebElement userPassword = driver.findElement(By.id("userPassword"));
        WebElement login = driver.findElement(By.id("login"));
     */

    //PageFactory Design Pattern
    @FindBy(id="userEmail")
    WebElement userEmail;
    @FindBy(id="userPassword")
    WebElement passwordEle;
    @FindBy(id="login")
    WebElement submitBtn;

    //Action Method
    public ProductCatalogue loginApplication(String email, String password){
        userEmail.sendKeys(email);
        passwordEle.sendKeys(password);
        submitBtn.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }
}

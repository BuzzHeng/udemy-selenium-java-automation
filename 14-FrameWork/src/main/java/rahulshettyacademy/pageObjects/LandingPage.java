package rahulshettyacademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

    WebDriver driver;

    //Constructor
    //Required to pass driver from test to this page.
    public LandingPage(WebDriver driver){
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

    //.ng-tns-c4-22.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;

    //Action Method
    public ProductCatalogue loginApplication(String email, String password){
        userEmail.sendKeys(email);
        passwordEle.sendKeys(password);
        submitBtn.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }

    public String getErrorMessage(){
        waitForElementToAppear(errorMessage);
        return errorMessage.getText();
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }
}

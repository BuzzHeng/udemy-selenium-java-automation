package rahulshettyacademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement selectCountryTextBox;

    @FindBy(xpath = "//button[contains(@class,'ta-item list-group-item ng-star-inserted')][2]")
    WebElement secondSelection;

    @FindBy(css = ".action__submit")
    WebElement placeOrderBtn;

    By dropdownResult = By.cssSelector(".ta-results");

    public void viewSelectCountry(String inputCountry){
        Actions a = new Actions(driver);
        a.sendKeys(selectCountryTextBox,inputCountry).build().perform();
        waitForElementToAppear(dropdownResult);
    }

    public void setSelectCountry(){
        secondSelection.click();
    }

    public ConfirmationPage placeOrder() {
        placeOrderBtn.click();
        return new ConfirmationPage(driver);
    }
}

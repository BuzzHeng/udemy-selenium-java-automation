package rahulshettyacademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponents;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;
    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts;

    @FindBy(css = ".totalRow button")
    WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Boolean verifyProductDisplay(String productName){
        return cartProducts.stream()
                .anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
    }

    public CheckoutPage goToCheckOut(){
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }

    //anyMatch - find any match within cartProducts

}

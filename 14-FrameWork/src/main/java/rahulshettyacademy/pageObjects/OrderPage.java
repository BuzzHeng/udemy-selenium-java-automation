package rahulshettyacademy.pageObjects;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponents;

import java.util.List;

public class OrderPage extends AbstractComponents {
    WebDriver driver;
    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> orderProducts;

    @FindBy(css = ".totalRow button")
    WebElement checkoutBtn;

    public OrderPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyOrderDisplay(String productName){
        return orderProducts.stream()
                .anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
    }

}

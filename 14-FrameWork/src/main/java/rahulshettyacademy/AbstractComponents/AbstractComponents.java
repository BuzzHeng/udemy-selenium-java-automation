package rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahulshettyacademy.pageObjects.CartPage;
import rahulshettyacademy.pageObjects.OrderPage;

import java.time.Duration;

public class AbstractComponents {
    WebDriver driver; //Local object

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;  //Set this class's driver using the given one
        PageFactory.initElements(driver,this);
    }

    //Reusable element should be in AbstractComponents Class
    @FindBy(css="[routerlink*='cart']")
    WebElement cartHeader;
    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;

    public CartPage goToCart(){
        waitForElementToAppear(cartHeader);
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public OrderPage goToOrder(){
        orderHeader.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }

    public void waitForElementToAppear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToAppear(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
        //Thread.sleep(1000);  // Temporary workaround to bypass backend spinner delay

        /*
         * NOTE:
         * The frontend waits for a secondary backend spinner service,
         * which causes a fixed delay (~4s) even after the spinner disappears.
         * Using Thread.sleep(1000) as a workaround to speed up execution,
         * instead of waiting the full 4s via WebDriverWait.
         * Uncomment below for proper wait in production:
         */
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
         wait.until(ExpectedConditions.invisibilityOf(ele));

    }

    public void waitForElementToDisappear(By findBy) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
}

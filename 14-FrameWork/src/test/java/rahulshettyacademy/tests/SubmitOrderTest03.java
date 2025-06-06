package rahulshettyacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import rahulshettyacademy.pageObjects.*;

import java.time.Duration;
import java.util.List;

public class SubmitOrderTest03 {
    private static final Logger log = LoggerFactory.getLogger(SubmitOrderTest03.class);

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String username = "scrashers@gmail.com";
        String password = "@QWE12345qwe";
        String productName = "ZARA COAT 3";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductCatalogue productCatalogue = loginPage.loginApplication(username,password);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");

        List<WebElement> products = productCatalogue.getProductList();

        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCart();

        //anyMatch - find any match within cartProducts
        String cartProduct = "ZARA COAT 3";
        boolean match = cartPage.verifyProductDisplay(cartProduct);

        //Assertion should only be in Test
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckOut();
        checkoutPage.viewSelectCountry("india");
        checkoutPage.setSelectCountry();
        ConfirmationPage confirmationPage = checkoutPage.placeOrder();

        //By Css
        // .ta-item:nth-of-type(2)
        String confirmMessage = confirmationPage.getConfirmMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();
    }
}

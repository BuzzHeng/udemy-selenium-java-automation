package rahulshettyacademy.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageObjects.*;

import java.io.IOException;
import java.util.List;

public class SubmitOrderTest04 extends BaseTest {

    @Test
    public void SubmitOrder() throws IOException, InterruptedException {

        String username = "scrashers@gmail.com";
        String password = "@QWE12345qwe";
        String productName = "ZARA COAT 3";

        LoginPage loginPage = launchApplication();
        ProductCatalogue productCatalogue = loginPage.loginApplication(username,password);

        List<WebElement> products = productCatalogue.getProductList();

        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCart();

        //anyMatch - find any match within cartProducts
        boolean match = cartPage.verifyProductDisplay(productName);

        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckOut();
        checkoutPage.viewSelectCountry("india");
        checkoutPage.setSelectCountry();
        ConfirmationPage confirmationPage = checkoutPage.placeOrder();

        String confirmMessage = confirmationPage.getConfirmMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();
    }
}

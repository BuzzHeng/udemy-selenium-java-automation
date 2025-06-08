package rahulshettyacademy.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageObjects.*;

import java.io.IOException;
import java.util.List;

public class SubmitOrderTest04 extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test
    public void SubmitOrder() throws IOException, InterruptedException {

        String username = "scrashers@gmail.com";
        String password = "@QWE12345qwe";


        // LoginPage loginPage = launchApplication();
        // 1. Removed by using @BeforeMethod
        // 2. Add loginPage at BaseTest so other class can access.

        ProductCatalogue productCatalogue = landingPage.loginApplication(username,password);

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
        // driver.close(); - Removed by using @AfterMethod
    }

    @Test(dependsOnMethods = {"SubmitOrder"})
    public void OrderHistoryTest(){
        // "ZARA COAT 3"
        ProductCatalogue productCatalogue = landingPage.loginApplication("scrashers@gmail.com","@QWE12345qwe");
        OrderPage orderPage = productCatalogue.goToOrder();
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    }
}

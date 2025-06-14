package rahulshettyacademy.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageObjects.*;
import rahulshettyacademy.data.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest_DataProvider06 extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData", groups="Purchase")
    //String username, String password, String productName
    //
    public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {

        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalogue.goToCart();
        //anyMatch - find any match within cartProducts
        boolean match = cartPage.verifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckOut();
        checkoutPage.viewSelectCountry("india");
        checkoutPage.setSelectCountry();
        ConfirmationPage confirmationPage = checkoutPage.placeOrder();
        String confirmMessage = confirmationPage.getConfirmMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods = {"SubmitOrder"})
    public void OrderHistoryTest(){
        // "ZARA COAT 3"
        ProductCatalogue productCatalogue = landingPage.loginApplication("scrashers@gmail.com","@QWE12345qwe");
        OrderPage orderPage = productCatalogue.goToOrder();
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    }

    //Hard Coded DataProvider
    /*
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"scrashers@gmail.com", "@QWE12345qwe", "ZARA COAT 3"}
                , {"hengheng@gmail.com", "Iamki000", "ADIDAS ORIGINAL"}};
    }
    */

    //HashMap DataProvider
    @DataProvider
    public Object[][] getData() throws IOException {
        /*HashMap<String,String> map = new HashMap<String,String>();
        map.put("email", "scrashers@gmail.com");
        map.put("password", "@QWE12345qwe");
        map.put("product", "ZARA COAT 3");

        HashMap<String,String> map1 = new HashMap<String,String>();
        map1.put("email", "hengheng@gmail.com");
        map1.put("password", "Iamki000");
        map1.put("product", "ADIDAS ORIGINAL");*/
        String userdir = System.getProperty("userdir") + "\\Github\\Udemy\\udemy-selenium-java-automation\\14-FrameWork\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.Json";
        List<HashMap<String, String>> data = getJsonDataToMap(userdir);
        return new Object[][]{ {data.get(0)},{data.get(1)}};
    }
}

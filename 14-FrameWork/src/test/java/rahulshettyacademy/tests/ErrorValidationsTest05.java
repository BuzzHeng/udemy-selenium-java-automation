package rahulshettyacademy.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageObjects.CartPage;
import rahulshettyacademy.pageObjects.ProductCatalogue;

import java.io.IOException;
import java.util.List;

public class ErrorValidationsTest05 extends BaseTest {

    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void LoginErrorValidation() throws IOException, InterruptedException {

        String username = "scrashers@gmail.com";
        String password = "@1234";
        String productName = "ZARA COAT 3";

        landingPage.loginApplication(username,password);
        //div[@aria-label='Incorrect email or password.']
        //div[@class='ng-tns-c4-20 toast-message ng-star-inserted']
        //.ng-tns-c4-22.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
        Assert.assertEquals("Incorrect email  password.", landingPage.getErrorMessage());
        // Fail test for extent report ng
    }

    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException {
        String username = "hengheng@gmail.com";
        String password = "Iamki000";
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication(username,password);
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCart();

        boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}

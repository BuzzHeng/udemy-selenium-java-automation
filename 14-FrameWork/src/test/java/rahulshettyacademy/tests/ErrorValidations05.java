package rahulshettyacademy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;

import java.io.IOException;

public class ErrorValidations05 extends BaseTest {

    @Test
    public void SubmitOrder() throws IOException, InterruptedException {

        String username = "scrashers@gmail.com";
        String password = "@1234";
        String productName = "ZARA COAT 3";

        landingPage.loginApplication(username,password);
        //div[@aria-label='Incorrect email or password.']
        //div[@class='ng-tns-c4-20 toast-message ng-star-inserted']
        //.ng-tns-c4-22.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

    }
}

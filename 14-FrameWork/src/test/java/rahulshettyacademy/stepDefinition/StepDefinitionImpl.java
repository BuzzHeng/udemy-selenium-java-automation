package rahulshettyacademy.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageObjects.*;

import java.io.IOException;
import java.util.List;

public class StepDefinitionImpl extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void I_Landed_on_Ecommerce_Page() throws IOException {
        //code
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password(String username, String password){
        productCatalogue = landingPage.loginApplication(username,password);
    }

    @When("^I add product (.+) from Cart$")
    public void i_add_product_from_cart(String productName) throws InterruptedException {
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCart();
    }

    @When("^Checkout (.+) and submit the order$")
    public void I_checkout_submit_order(String productName){
        CartPage cartPage = productCatalogue.goToCart();
        boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckOut();
        checkoutPage.viewSelectCountry("india");
        checkoutPage.setSelectCountry();
        confirmationPage = checkoutPage.placeOrder();
    }

    @Then("{string} messages is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string){
        String confirmMessage = confirmationPage.getConfirmMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
        driver.close();
    }

    @Then("{string}, message is displayed")
    public void messageIsDisplayed(String arg0) {
        Assert.assertEquals(arg0, landingPage.getErrorMessage());
        driver.close();
    }
}


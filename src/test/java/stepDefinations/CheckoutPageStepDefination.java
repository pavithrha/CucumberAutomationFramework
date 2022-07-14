package stepDefinations;


import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

import java.io.IOException;

public class CheckoutPageStepDefination {
    TestContextSetup testContextSetup;
    public CheckoutPage checkoutPage;
    public CheckoutPageStepDefination(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^Validate \"([^\"]*)\", promo apply and place order button on checkout page$")
    public void validateNamePromoNPlaceOrderBtn(String productName) {
        Assert.assertEquals(checkoutPage.getProductName(), testContextSetup.landingPageProductName);
        Assert.assertTrue(checkoutPage.validatePromoApplyBtn());
        Assert.assertTrue(checkoutPage.validatePlaceOrderBtn());
        Assert.assertEquals(checkoutPage.getProductQty(), testContextSetup.landingPageProductQty);
    }

}

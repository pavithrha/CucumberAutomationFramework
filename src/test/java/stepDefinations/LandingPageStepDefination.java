package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;
import java.io.IOException;


public class LandingPageStepDefination {
    TestContextSetup testContextSetup;
    public LandingPage landingPage;
    public LandingPageStepDefination(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on green cart landing page")
    public void user_is_on_green_cart_landing_page() throws IOException {
        Assert.assertTrue(landingPage.getTitle().contains("GreenKart"));
    }
    @When("^User searched with Shortname \"([^\"]*)\" and extracted actual name of the product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
        //LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchProduct(shortName);
        Thread.sleep(3000);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
    }

    @When("^User searched product \"([^\"]*)\" and edit the quantity \"([^\"]*)\" and add product to cart$")
    public void userSearchedProductAddProductNAddToCart(String productName, int qty) throws InterruptedException {
        //LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        testContextSetup.landingPageProductQty = qty;
        landingPage.searchProduct(productName);
        Thread.sleep(2000);
        landingPage.addProduct(qty);
        landingPage.addProductToCart();
        testContextSetup.landingPageProductName = landingPage.getProductName();
    }

    @Then("View the cart and click on Proceed to checkout")
    public void viewCartNProceedToCheckout() throws InterruptedException {
        //LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.clickOnCart();
        landingPage.clickonProccedToCheckout();
        Thread.sleep(2000);
    }
}

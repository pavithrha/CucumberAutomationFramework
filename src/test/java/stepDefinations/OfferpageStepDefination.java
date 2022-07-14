package stepDefinations;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

import java.io.IOException;


public class OfferpageStepDefination {
    public String offerPageProductName;
    TestContextSetup testContextSetup;
    OffersPage offersPage;

    //Constructor
    public OfferpageStepDefination(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.offersPage = testContextSetup.pageObjectManager.getOffersPage();
    }


    public void switchToOffersPage() {

        LandingPage landingPage = testContextSetup.pageObjectManager.landingPage;
        landingPage.clickTopDealsPage();
        testContextSetup.genericUtils.switchWindowToChild();
    }

    @Then("^Validate product exist$")
    public void validateProductExist() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }

    @Then("^User searched with same shortname \"([^\"]*)\" in offers page$")
    public void userSearchedWithSameShortnameNameInOffersPage(String shortName) throws InterruptedException {
        switchToOffersPage();
        offersPage.searchProduct(shortName);
        offerPageProductName = offersPage.getProductName();
        Thread.sleep(2000);
    }
}

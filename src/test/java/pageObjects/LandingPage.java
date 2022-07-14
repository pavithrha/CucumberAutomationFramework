package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

public class LandingPage {
    By search = By.xpath("//input[@type='search']");
    By productName = By.xpath("//h4[@class='product-name']");
    By topDeals = By.linkText("Top Deals");
    WebDriver driver;
    By addProductQty = By.xpath("//div[@class='stepper-input']/a[@class='increment']");
    By getQuantity = By.xpath("//div[@class='stepper-input']/input");
    By addToCart = By.xpath("//button[text()='ADD TO CART']");
    By viewCart = By.xpath("//a[@class='cart-icon']");
    By proceedToCheckout = By.xpath("//button[text()='PROCEED TO CHECKOUT']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String shortName) {
        driver.findElement(search).sendKeys(shortName);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public void clickTopDealsPage() {
        driver.findElement(topDeals).click();
    }

    public void addProduct(int qty) {
        for (int i = 1; i < qty; i++) {
            driver.findElement(addProductQty).click();
        }
    }

    public void addProductToCart() {
        driver.findElement(addToCart).click();
    }

    public void clickOnCart() {
        driver.findElement(viewCart).click();
    }

    public void clickonProccedToCheckout() {
        driver.findElement(proceedToCheckout).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}

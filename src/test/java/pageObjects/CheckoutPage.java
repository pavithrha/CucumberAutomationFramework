package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;
    By productName = By.xpath("//p[@class='product-name']");
    By productQty = By.xpath("//p[@class='quantity']");
    By productPrice = By.xpath("//tr/td[4]/p[@class='amount']");
    By productTotal = By.xpath("//tr/td[5]/p[@class='amount']");
    By promoApplyBtn = By.xpath("//button[@class='promoBtn']");
    By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public int getProductQty() {
        return Integer.valueOf(driver.findElement(productQty).getText());
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    public String getProductTotalPrice() {
        return driver.findElement(productTotal).getText();
    }

    public boolean validatePromoApplyBtn() {
        return driver.findElement(promoApplyBtn).isDisplayed();
    }

    public boolean validatePlaceOrderBtn() {
        return driver.findElement(placeOrderBtn).isDisplayed();
    }


}

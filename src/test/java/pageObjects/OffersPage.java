package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    WebDriver driver;
    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    By search = By.id("search-field");
    By productName = By.xpath("//tr/td[1]");

    public void searchProduct(String name) {
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }



}

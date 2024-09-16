package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    WebDriver driver;

    // Locators
    By title = By.cssSelector("[data-test=\"title\"]");
    By itemQuantity = By.cssSelector("[data-test=\"item-quantity\"]");
    By itemPrice = By.cssSelector("[data-test=\"inventory-item-price\"]");

    By paymentInfo = By.cssSelector("[data-test=\"payment-info-value\"]");
    By shippingInfo = By.cssSelector("[data-test=\"shipping-info-value\"]");
    By totalPrice = By.cssSelector("[data-test=\"total-label\"]");

    By finishButton = By.cssSelector("[data-test=\"finish\"]");


    // Constructor
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    //TODO checking for title in BaseTest

    public String getQuantity(){
        return driver.findElement(itemQuantity).getText();
    }

    public String getItemPrice(){
        return driver.findElement(itemPrice).getText();
    }

    public String getPaymentInfo(){ return driver.findElement(paymentInfo).getText();}

    public String getShippingInfo(){ return driver.findElement(shippingInfo).getText();}

    public String getTotalPrice(){ return driver.findElement(totalPrice).getText();}

    public void finishCheckout(){
        driver.findElement(finishButton).click();
    }
}

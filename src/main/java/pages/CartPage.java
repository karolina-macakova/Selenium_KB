package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    // Locators
    By itemQuantity = By.cssSelector("[data-test=\"item-quantity\"]");
    By itemPrice = By.cssSelector("[data-test=\"inventory-item-price\"]");
    By checkoutButton = By.cssSelector("[data-test=\"checkout\"]");


    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    //TODO checking for title in BaseTest

    public String getQuantity(){
        return driver.findElement(itemQuantity).getText();
    }

    public String getPrice(){
        return driver.findElement(itemPrice).getText();
    }

    public void checkout(){
        driver.findElement(checkoutButton).click();
    }
}

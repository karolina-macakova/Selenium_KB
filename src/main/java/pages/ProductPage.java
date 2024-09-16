package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    // Locators
    By inventory = By.cssSelector("[data-test=\"inventory-container\"]");
    By addToCartButton = By.cssSelector("[data-test=\"add-to-cart-sauce-labs-backpack\"]");
    By cartBadge = By.cssSelector("[data-test=\"shopping-cart-badge\"]");
    By cart = By.cssSelector("[data-test=\"shopping-cart-link\"]");


    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    //TODO checking for title in BaseTest
    public Boolean isInventoryPresent() {
        try{
            driver.findElement(inventory);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public void addToCart(){
        driver.findElement(addToCartButton).click();
    }

    public String getBadgeNumber(){
        return driver.findElement(cartBadge).getText();
    }

    public void viewCart(){
        driver.findElement(cart).click();
    }
}

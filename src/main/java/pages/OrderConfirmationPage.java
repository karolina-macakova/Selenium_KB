package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    WebDriver driver;

    // Locators
    By title = By.cssSelector("[data-test=\"title\"]");
    By completeHeader = By.cssSelector("[data-test=\"complete-header\"]");
    By backHomeButton = By.cssSelector("[data-test=\"back-to-products\"]");


    // Constructor
    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    //TODO checking for title in BaseTest

    public boolean verifyHeader(){
        return driver.findElement(completeHeader).getText().equals("Thank you for your order!");
    }

    public void goBackHome(){
        driver.findElement(backHomeButton).click();
    }
}

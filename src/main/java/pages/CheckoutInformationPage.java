package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {
    WebDriver driver;

    // Locators
    By title = By.cssSelector("[data-test=\"title\"]");
    By firstNameField = By.cssSelector("[data-test=\"firstName\"]");
    By lastNameField = By.cssSelector("[data-test=\"lastName\"]");
    By postalCodeField = By.cssSelector("[data-test=\"postalCode\"]");
    By continueButton = By.cssSelector("[data-test=\"continue\"]");


    // Constructor
    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    //TODO checking for title in BaseTest

    public void setInformation(String firstName, String lastName, String postalCode){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void continueCheckout(){
        driver.findElement(continueButton).click();
    }
}

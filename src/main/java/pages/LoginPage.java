package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators
    By usernameField = By.cssSelector("[data-test=\"username\"]");
    By passwordField = By.cssSelector("[data-test=\"password\"]");
    By loginButton = By.cssSelector("[data-test=\"login-button\"]");
    By errorMessage = By.cssSelector("[data-test=\"error\"]");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void login(String username, String password) {
        if (username != null) {
            driver.findElement(usernameField).sendKeys(username);
        }

        if (password != null) {
            driver.findElement(passwordField).sendKeys(password);
        }

        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
       return driver.findElement(errorMessage).getText();
    }
}

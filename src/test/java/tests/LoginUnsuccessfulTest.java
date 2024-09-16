package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;
import pages.ProductPage;

public class LoginUnsuccessfulTest extends BaseTest{

    //TODO @CsvFileSource
    @ParameterizedTest
    @CsvSource({"standard_user, wrong_password, Epic sadface: Username and password do not match any user in this service",
                "locked_out_user, secret_sauce, 'Epic sadface: Sorry, this user has been locked out.'",
                ", secret_sauce, Epic sadface: Username is required",
                "standard_user,, Epic sadface: Password is required"})
    public void testInvalidLogin(String username, String password, String errorMessageExpected) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Check if error message was displayed
        Assertions.assertEquals(errorMessageExpected, loginPage.getErrorMessage());

        // TODO nechat?
        ProductPage productPage = new ProductPage(driver);
        Assertions.assertEquals(false, productPage.isInventoryPresent());
    }
}

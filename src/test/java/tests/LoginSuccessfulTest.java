package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;
import pages.ProductPage;

public class LoginSuccessfulTest extends BaseTest{

    //TODO @CsvFileSource
    @ParameterizedTest
    @CsvSource({"standard_user, secret_sauce",
                "performance_glitch_user, secret_sauce"})
    public void testValidLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Check if login is successful
        ProductPage productPage = new ProductPage(driver);
        Assertions.assertTrue(productPage.isInventoryPresent());
    }
}

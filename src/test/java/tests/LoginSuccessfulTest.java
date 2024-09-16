package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.LoginPage;
import pages.ProductPage;

public class LoginSuccessfulTest extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(resources = "/loginSuccessfulData.csv")
    public void testValidLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Check product page was displayed
        ProductPage productPage = new ProductPage(driver);
        Assertions.assertTrue(productPage.isInventoryPresent());
    }
}

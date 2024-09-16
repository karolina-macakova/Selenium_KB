package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.LoginPage;
import pages.ProductPage;

public class LoginUnsuccessfulTest extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(resources = "/loginUnsuccessfulData.csv")
    public void testInvalidLogin(String username, String password, String errorMessageExpected) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Check if error message was displayed
        Assertions.assertEquals(errorMessageExpected, loginPage.getErrorMessage());

        // product page is not shown
        ProductPage productPage = new ProductPage(driver);
        Assertions.assertEquals(false, productPage.isInventoryPresent());
    }
}

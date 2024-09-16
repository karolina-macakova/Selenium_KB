package tests;

import base.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.*;


public class E2ETest extends BaseTest {

    //TODO @CsvFileSource
    @ParameterizedTest
    @CsvSource({"standard_user, secret_sauce, 1, $29.99, ABC, XYZ, 123, SauceCard #31337, Free Pony Express Delivery!, Total: $32.39"})
    public void addToCart(String username, String password,
                          String quantity, String price,
                          String firstName, String lastName, String postalCode,
                          String paymentInfo, String shippingInfo, String totalPrice) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // add to cart
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();

        //verify cartBadge
        Assertions.assertEquals(quantity, productPage.getBadgeNumber());

        //go to cart
        productPage.viewCart();

        //verify cart
        CartPage cartPage = new CartPage(driver);
        Assertions.assertEquals(quantity, cartPage.getQuantity());
        Assertions.assertEquals(price, cartPage.getPrice());

        //proceed to checkout
        cartPage.checkout();

        //fill shipping details
        CheckoutInformationPage infoPage = new CheckoutInformationPage(driver);
        infoPage.setInformation(firstName, lastName, postalCode);
        infoPage.continueCheckout();

        //review order
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        Assertions.assertEquals(quantity, overviewPage.getQuantity());
        Assertions.assertEquals(price, overviewPage.getItemPrice());
        Assertions.assertEquals(paymentInfo, overviewPage.getPaymentInfo());
        Assertions.assertEquals(shippingInfo, overviewPage.getShippingInfo());
        Assertions.assertEquals(totalPrice, overviewPage.getTotalPrice());

        //place the order
        overviewPage.finishCheckout();

        //verify order confirmation
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        Assertions.assertTrue(orderConfirmationPage.verifyHeader());

        //go back to products
        orderConfirmationPage.goBackHome();
        Assertions.assertTrue(productPage.isInventoryPresent());
    }
}

package com.solvd;

import com.solvd.constans.SidebarTitle;
import com.solvd.gui.pages.common.*;
import com.solvd.service.ClientService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class ProductTest extends BaseTest {

    @DataProvider(name = "useTestProductQuantityData", parallel=true)
    public Object[][] userRegisterDataProvider() {
        return new Object[][]{
                {"-1"},
                {"abc"},
        };
    }

    @Test(testName= "#TC-007")
    public void verifyCatalogToProductNavigation() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isProductListPresent(), "Products section on homepage is empty");

        CatalogPageBase catalogPage =  homePage.clickToggleMenuLink()
                .clickMenuButtonByName(String.valueOf(SidebarTitle.CATALOG));
        assertTrue(catalogPage.isProductListPresent(), "Product section on catalog page is empty");

        catalogPage.selectRandomProduct();
        String productName = catalogPage.getSelectedProductName();
        String productPrice = catalogPage.getSelectedProductPrice();
        ProductPageBase productPage = catalogPage.clickSelectedProduct();

        assertEquals(productPage.getProductName(), productName,
                "Product name on product page don't match selected one");
        assertEquals(productPage.getProductPrice(), productPrice,
                "Product price on product page don't match selected one");
    }

    @Test(testName = "#TC-005")
    public void verifyAddProductToCart() {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isProductListPresent(), "Products section on homepage is empty");

        homePage.selectRandomProduct();
        String productName = homePage.getSelectedProductName();
        String productPrice = homePage.getSelectedProductPrice();
        ProductPageBase productPage = homePage.clickSelectedProduct();

        softAssert.assertEquals(productPage.getProductName(), productName,
                "Product name on product page doesn't match selected one");
        softAssert.assertEquals(productPage.getProductPrice(), productPrice,
                "Product price on product page doesn't match selected one");

        productPage.clickAddToCartButton();
        CartPageBase cartPage = productPage.getHeader().clickCartLink();

        assertFalse(cartPage.isEmptyCartMessagePresent(), "Message should not be visible after adding product to cart");
        assertEquals(cartPage.getProductName(), productName, "The name is not equal to selected product");
        assertEquals(cartPage.getProductPrice(), productPrice,"The price is not equal to selected product");

        softAssert.assertAll();
    }

    @Test(testName = "#TC-008", dataProvider = "useTestProductQuantityData")
    public void verifyQuantityField(String quantity) {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isProductListPresent(), "Products section on homepage is empty");

        homePage.selectRandomProduct();
        ProductPageBase productPage = homePage.clickSelectedProduct();
        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCartLink();
        cartPage.setInputQuantity(quantity);
        assertEquals(cartPage.getInputQuantity(), "1",
                "The quantity input don't change after not numeric input or negative number");
    }

    @Test(testName = "#TC-006")
    public void verifyCheckoutProcess() {
        ClientService clientService = new ClientService();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isProductListPresent(), "Products section on homepage is empty");

        homePage.selectRandomProduct();
        ProductPageBase productPage = homePage.clickSelectedProduct();
        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCartLink();
        CheckOutPageBase checkOutPage = cartPage.clickCheckoutButton();
        checkOutPage.fillCheckOutForm(clientService.createClient());
        checkOutPage.clickPayNowButton();

        assertTrue(homePage.isPageOpened(), "User should be redirected to the homepage after payment");
        assertTrue(homePage.isProductListPresent(), "Elements on homepage should be visible");
    }
}

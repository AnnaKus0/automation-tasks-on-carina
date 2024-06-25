package com.solvd;

import com.solvd.constans.SidebarTitle;
import com.solvd.gui.pages.common.*;
import com.solvd.service.ClientService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class MobileProductTest extends BaseTest {

    @DataProvider(name = "useTestProductQuantityData")
    public Object[][] userRegisterDataProvider() {
        return new Object[][]{
                {"-1"},
                {"abc"},
        };
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
        assertTrue(productPage.getHeader().checkCartQuantity(),
                "After adding product to the cart, user should see the number of selected products");
        CartPageBase cartPage = productPage.getHeader().clickCartLink();

        assertFalse(cartPage.isEmptyCartMessagePresent(),
                "The empty cart message should not be visible after adding product to the cart");
        softAssert.assertEquals(cartPage.getProductName(), productName,
                "Product name on cart page doesn't match selected one");
        softAssert.assertEquals(cartPage.getProductPrice(), productPrice,
                "Product price on cart page doesn't match selected one");
    }

    @Test(testName= "#TC-007")
    public void verifyCatalogAndProductPage() {
        SoftAssert softAssert = new SoftAssert();

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

        softAssert.assertEquals(productPage.getProductName(), productName,
                "Product name on cart page doesn't match selected one");
        softAssert.assertEquals(productPage.getProductPrice(), productPrice,
                "Product name on cart page doesn't match selected one");
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
        assertEquals(cartPage.getInputQuantity(), "1", "The quantity input don't change to 1");
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
        assertTrue(homePage.isAnyElementPresent(), "Elements on homepage should be visible");
    }
}

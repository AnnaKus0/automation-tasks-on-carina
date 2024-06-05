package com.solvd;

import com.solvd.constans.SidebarTitle;
import com.solvd.gui.pages.common.*;
import com.solvd.service.ClientService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MobileProductTest extends BaseTest {

    @DataProvider(name = "useTestProductQuantityData", parallel=true)
    public Object[][] userRegisterDataProvider() {
        return new Object[][]{
                {"-1"},
                {"abc"},
        };
    }

    @Test(testName = "#TC-005")
    public void verifyAddProductToCart() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isProductListPresent(), "Products section on homepage is empty");

        homePage.selectRandomProduct();
        String productName = homePage.getSelectedProductName();
        ProductPageBase productPage = homePage.clickSelectedProduct();

        assertEquals(productPage.getProductTitle(), productName, "Product name on product page don't matches selected one");
        //assertEquals(productPage.getPrice(), productPrice, "Product name on product page don't matches selected one");
        //assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");

        productPage.clickAddToCartButton();
        CartPageBase cartPage = productPage.getHeader().mobileClickCartOutLink();

        assertFalse(cartPage.isEmptyCartMessagePresent(), "Message should not be visible after adding product to cart");
        assertEquals(cartPage.getProductName(), productName, "The name is not equal to selected product");
        //assertEquals(cartPage.getProductPrice(), productPrice,"The price is not equal to selected product");
    }

//    @Test(testName= "#TC-007")
//    public void verifyCatalogAndProductPage() {
//        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
//        homePage.open();
//        assertTrue(homePage.isProductListPresent(), "Products section on homepage is empty");
//
//        CatalogPageBase catalogPage =  homePage.clickToggleMenuLink()
//                .clickMenuButtonByName(String.valueOf(SidebarTitle.CATALOG));
//        assertTrue(catalogPage.isProductListPresent(), "Product section on catalog page is empty");
//
//        catalogPage.selectRandomProduct();
//        String productName = catalogPage.getSelectedProductName();
//        ProductPageBase productPage = catalogPage.clickSelectedProduct();
//
//        assertEquals(productPage.getProductTitle(), productName, "Product name on product page don't matches selected one");
//        //assertEquals(productPage.getPrice(), productPrice, "Product price on product page don't match selected one");
//        //assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");
//    }
//
//    @Test(testName = "#TC-008", dataProvider = "useTestProductQuantityData")
//    public void verifyQuantityField(String quantity) {
//        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
//        homePage.open();
//        assertTrue(homePage.isProductListPresent(), "Products section on homepage is empty");
//
//        homePage.selectRandomProduct();
//        ProductPageBase productPage = homePage.clickSelectedProduct();
//        productPage.clickAddToCartButton();
//
//        CartPageBase cartPage = productPage.getHeader().mobileClickCartOutLink();
//        cartPage.setInputQuantity(quantity);
//        assertEquals(cartPage.getInputQuantity(), "1", "The quantity input don't change to 1");
//    }
//
//    @Test(testName = "#TC-006")
//    public void verifyCheckoutProcess() {
//        ClientService clientService = new ClientService();
//
//        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
//        homePage.open();
//        assertTrue(homePage.isProductListPresent(), "Products section on homepage is empty");
//
//        homePage.selectRandomProduct();
//        ProductPageBase productPage = homePage.clickSelectedProduct();
//        productPage.clickAddToCartButton();
//
//        CartPageBase cartPage = productPage.getHeader().mobileClickCartOutLink();
//
//        CheckOutPageBase checkOutPage = cartPage.clickCheckoutButton();
//        checkOutPage.fillCheckOutForm(clientService.createClient());
//        checkOutPage.clickPayNowButton();
//
//        assertTrue(homePage.isPageOpened(), "User should be redirected to the homepage after payment");
//        assertTrue(homePage.isAnyElementPresent(), "Elements on homepage should be visible");
//    }
}

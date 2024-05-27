package com.solvd;

import com.solvd.gui.components.product_card.ProductCard;
import com.solvd.gui.pages.common.*;
import com.solvd.gui.pages.desktop.HomePage;
import com.solvd.service.ClientService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductTest extends BaseTest {

//    @Test(testName = "#TC005")
//    public void verifyAddProductToCart() {
//        HomePageBase homePage = new HomePage(getDriver());
//
//        homePage.selectRandomProduct();
//        String selectedProductName =  homePage.getSelectedProductName();
//        ProductPageBase productPage = homePage.clickSelectedProduct();
//
//        assertEquals(productPage.getProductTitle(), selectedProductName, "Product name on product page don't matches chosen one");
//        assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");
//
//        productPage.clickAddToCartButton();
//
//        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();
//
//        assertEquals(cartPage.getProductName(), selectedProductName, "The name is not equal to chosen product");
//        assertEquals(cartPage.getProductPrice(), selectedProductName, "The price is not equal to chosen product");
//    }

    @Test(testName= "#TC007")
    public void verifyCatalogAndProductPage() {
        String expectedTitle = "Black heels";

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Homepage doesn't open");

        CatalogPageBase catalogPage =  homePage.getSideMenu().clickMenuButtonByName("Catalog");
        assertTrue(catalogPage.isPageOpened(), "Homepage doesn't open");

        ProductPageBase productPage =  catalogPage.clickOnProductByName(expectedTitle);
        assertTrue(productPage.isPageOpened(), "Homepage doesn't open");

        assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");
        assertEquals(productPage.getProductTitle(), expectedTitle, "Product title is incorrect");
    }

    @Test(testName = "#TC008", dataProvider = "useTestDataProduct", threadPoolSize = 2, invocationCount = 2)
    public void test_ClickProduct_AddToCart_CheckQuantityInput(String expectedTitle, String expectedPrice) {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        ProductPageBase productPage = homePage.clickOnProductByName(expectedTitle);
        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();
        cartPage.setInputQuantity("-1");

        assertEquals(cartPage.getInputQuantity(), "1", "The quantity input don't change from negative number to positive");
    }

    @Test(testName = "#TC006", dataProvider = "useTestDataProduct", threadPoolSize = 2, invocationCount = 2)
    public void test_AddToCart_CheckOut(String expectedTitle, String expectedPrice) {
        ClientService clientService = new ClientService();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProductPageBase productPage = homePage.clickOnProductByName(expectedTitle);
        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();
        CheckOutPageBase checkOutPage = cartPage.clickCheckoutButton();
        checkOutPage.fillCheckOutForm(clientService.createClient());
        checkOutPage.clickPayNowButton();
        assertEquals(homePage.isPageOpened(), "User should be redirected to the homepage after payment");
    }

}

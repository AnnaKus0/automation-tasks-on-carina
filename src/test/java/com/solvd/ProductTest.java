package com.solvd;

import com.solvd.constans.SidebarTitle;
import com.solvd.gui.components.product_card.ProductCard;
import com.solvd.gui.pages.common.*;
import com.solvd.gui.pages.desktop.HomePage;
import com.solvd.service.ClientService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductTest extends BaseTest {

    @Test(testName = "#TC005", threadPoolSize = 2, invocationCount = 2)
    public void verifyAddProductToCart() {
        HomePageBase homePage = getHomePage();
        assertTrue(homePage.isProductListPresent(), "Product section is empty");

        ProductPageBase productPage =  homePage.clickRandomProduct();
        assertTrue(productPage.isPageOpened(), "Catalog page doesn't open");
        assertEquals(productPage.getProductTitle(), "Product name on product page don't matches chosen one");
        assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");

        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();

        assertEquals(cartPage.getProductName(), "The name is not equal to chosen product");
        assertEquals(cartPage.getProductPrice(), "The price is not equal to chosen product");
    }

    @Test(testName= "#TC007", threadPoolSize = 2, invocationCount = 2)
    public void verifyCatalogAndProductPage() {
        HomePageBase homePage = getHomePage();

        CatalogPageBase catalogPage =  homePage.getSideMenu().clickMenuButtonByName(String.valueOf(SidebarTitle.CATALOG));
        assertTrue(catalogPage.isPageOpened(), "Catalog page doesn't open");
        assertTrue(catalogPage.isProductListPresent(), "Product section is empty");

        ProductPageBase productPage =  catalogPage.clickRandomProduct();
        assertTrue(productPage.isPageOpened(), "Homepage doesn't open");

        assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");
        assertEquals(productPage.getProductTitle(), "Product title is incorrect");
    }

    @Test(testName = "#TC008", threadPoolSize = 2, invocationCount = 2)
    public void verifyNegativeValuesNotAllowedInQuantityField() {
        HomePageBase homePage = getHomePage();

        ProductPageBase productPage = homePage.clickRandomProduct();
        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();
        cartPage.setInputQuantity("-1");

        assertEquals(cartPage.getInputQuantity(), "1", "The quantity input don't change from negative number to positive");
    }

    @Test(testName = "#TC006", threadPoolSize = 2, invocationCount = 2)
    public void verifyCheckoutProcess() {
        ClientService clientService = new ClientService();

        HomePageBase homePage = getHomePage();
        ProductPageBase productPage = homePage.clickRandomProduct();
        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();
        CheckOutPageBase checkOutPage = cartPage.clickCheckoutButton();

        checkOutPage.fillCheckOutForm(clientService.createClient());
        checkOutPage.clickPayNowButton();

        assertEquals(homePage.isPageOpened(), "User should be redirected to the homepage after payment");
        assertEquals(homePage.isAnyElementPresent(), "Elements on HomePage should be visible");
    }

}

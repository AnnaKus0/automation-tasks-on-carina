package com.solvd;

import com.solvd.gui.pages.common.*;
import com.solvd.gui.pages.desktop.HomePage;
import com.solvd.pages.common.AbstractTest;

import com.solvd.service.ClientService;
import com.solvd.util.ScreenshotListener;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(ScreenshotListener.class)
public class ProductTest implements IAbstractTest {

    @Test(testName = "#TC005", threadPoolSize = 2, invocationCount = 2)
    public void verifyAddProductToCart(String expectedTitle, String expectedPrice) {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        homePage.chooseRandomProduct();
        String selectedProduct = homePage.getSelectedProductName();
        ProductPageBase productPage = homePage.clickSelectedProduct();

        assertEquals(productPage.getProductTitle(), selectedProduct, "Product name on product page don't matches chosen one");
//        assertEquals(productPage.getProductPrice(), expectedPrice, "Product price on product page don't matches chosen one");
        assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");

        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();

        assertEquals(cartPage.getProductName(), expectedTitle, "The name is not equal to chosen product");
        assertEquals(cartPage.getProductPrice(), expectedPrice, "The price is not equal to chosen product");
    }

}

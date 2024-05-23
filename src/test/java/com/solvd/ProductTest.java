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

    @DataProvider(name = "useTestDataProduct", parallel=true)
    public Object[][] userSignUpDataProvider() {
        return new Object[][]{
                {"Grey jacket", "£55.00"}
        };
    }

    @Test(testName = "#TC005", dataProvider = "useTestDataProduct", threadPoolSize = 2, invocationCount = 2)
    public void verifyAddProductToCart(String expectedTitle, String expectedPrice) {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        ProductPageBase productPage = homePage.clickOnProductByName(expectedTitle);
        assertEquals(productPage.getProductTitle(), expectedTitle, "Product name on product page don't matches chosen one");
        assertEquals(productPage.getProductPrice(), expectedPrice, "Product price on product page don't matches chosen one");
        assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");

        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();

        assertEquals(cartPage.getProductName(), expectedTitle, "The name is not equal to chosen product");
        assertEquals(cartPage.getProductPrice(), expectedPrice, "The price is not equal to chosen product");
    }

    @Test(testName= "#TC007", dataProvider = "useTestDataProduct", threadPoolSize = 2, invocationCount = 2)
    public void verifyProductsInCatalogAndDetailsOnProductPage(String expectedTitle, String expectedPrice) {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        CatalogPageBase catalogPage =  homePage.getSideMenu().clickMenuButtonByName("Catalog");
        ProductPageBase productPage =  catalogPage.clickOnProductByName(expectedTitle);

        assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");
        assertEquals(productPage.getProductTitle(), expectedTitle, "Product title is incorrect");
        assertEquals(productPage.getProductPrice(), expectedPrice, "Product price is incorrect");
    }

    @Test(testName = "#TC008", dataProvider = "useTestDataProduct", threadPoolSize = 2, invocationCount = 2)
    public void verifyQuantityFieldInCartPage(String expectedTitle, String expectedPrice) {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        ProductPageBase productPage = homePage.clickOnProductByName(expectedTitle);
        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();
        cartPage.setInputQuantity("-1");

        assertEquals(cartPage.getInputQuantity(), "1", "The quantity input don't change from negative number to positive");
    }

    @Test(testName = "#TC006", dataProvider = "useTestDataProduct", threadPoolSize = 2, invocationCount = 2)
    public void verifyCheckOutProcess(String expectedTitle, String expectedPrice) {
        ClientService clientService = new ClientService();

        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        ProductPageBase productPage = homePage.clickOnProductByName(expectedTitle);
        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();
        CheckOutPageBase checkOutPage = cartPage.clickCheckoutButton();
        checkOutPage.fillCheckOutForm(clientService.createClient());
        checkOutPage.clickPayNowButton();
        assertEquals(getDriver().getCurrentUrl(), baseUrl, "User should be redirected to the homepage after payment");
    }

}

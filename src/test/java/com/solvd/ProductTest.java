package com.solvd;

import com.solvd.constans.SidebarTitle;
import com.solvd.constans.URLType;
import com.solvd.gui.pages.common.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductTest extends BaseWebTest {

    @Test(testName = "#TC005")
    public void verifyAddProductToCart() {
        HomePageBase homePage = getHomePage();
        assertTrue(homePage.isProductListPresent(), "Product section is empty");

        homePage.selectRandomProduct();
        String productName = homePage.getSelectedProductName();
        String productNameUrl = productName.toLowerCase().replace(" ", "-");
        ProductPageBase productPage = homePage.clickSelectedProduct(URLType.HOMEPAGE, productNameUrl);

        //assertEquals(productPage.getCurrentUrl(), R.TESTDATA.get("URL.product"), "Product page doesn't open");
        assertEquals(productPage.getProductTitle(), productName, "Product name on product page don't matches chosen one");

        assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");
        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();
        //assertEquals(cartPage.getCurrentUrl(), R.TESTDATA.get("URL.cart"), "Cart page doesn't open");

        assertEquals(cartPage.getProductName(), productName,"The name is not equal to chosen product");
        assertEquals(cartPage.getProductPrice(), productName,"The price is not equal to chosen product");
    }

 /*   @Test(testName= "#TC007", threadPoolSize = 2, invocationCount = 2)
    public void verifyCatalogAndProductPage() {
        HomePageBase homePage = getHomePage();

        CatalogPageBase catalogPage =  homePage.getSideMenu().clickMenuButtonByName(String.valueOf(SidebarTitle.CATALOG));

        //assertEquals(catalogPage.getCurrentUrl(), R.TESTDATA.get("URL.catalog"), "Catalog page doesn't open");
        assertTrue(catalogPage.isProductListPresent(), "Product section is empty");

        catalogPage.selectRandomProduct();
        String productName = catalogPage.getSelectedProductName();
        ProductPageBase productPage = catalogPage.clickSelectedProduct();
        //assertEquals(productPage.getCurrentUrl(), R.TESTDATA.get("URL.product"), "Product page doesn't open");

        assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");
        assertEquals(productPage.getProductTitle(), productName, "Product title is incorrect");
    }

    @Test(testName = "#TC008", threadPoolSize = 2, invocationCount = 2)
    public void verifyNegativeValuesNotAllowedInQuantityField() {
        HomePageBase homePage = getHomePage();

        homePage.selectRandomProduct();
//        String productName = homePage.getSelectedProductName();
        ProductPageBase productPage = homePage.clickSelectedProduct();

        assertEquals(productPage.getCurrentUrl(), R.TESTDATA.get("URL.product"), "Product page doesn't open");
        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();
        assertEquals(cartPage.getCurrentUrl(), R.TESTDATA.get("URL.cart"), "Cart page doesn't open");
        cartPage.setInputQuantity("-1");

        assertEquals(cartPage.getInputQuantity(), "1", "The quantity input don't change from negative number to positive");
    }

    @Test(testName = "#TC006", threadPoolSize = 2, invocationCount = 2)
    public void verifyCheckoutProcess() {
        ClientService clientService = new ClientService();

        HomePageBase homePage = getHomePage();

        homePage.selectRandomProduct();
//        String productName = homePage.getSelectedProductName();
        ProductPageBase productPage = homePage.clickSelectedProduct();
        assertEquals(productPage.getCurrentUrl(), R.TESTDATA.get("URL.product"), "Product page doesn't open");

        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();
        assertEquals(cartPage.getCurrentUrl(), R.TESTDATA.get("URL.cart"), "Cart page doesn't open");

        CheckOutPageBase checkOutPage = cartPage.clickCheckoutButton();
        assertEquals(checkOutPage.getCurrentUrl(), R.TESTDATA.get("URL.checkout"), "Checkout page doesn't open");
        checkOutPage.fillCheckOutForm(clientService.createClient());
        checkOutPage.clickPayNowButton();

        assertEquals(homePage.getCurrentUrl(), R.TESTDATA.get("URL.base"),
                "User should be redirected to the homepage after payment");
        assertEquals(homePage.isAnyElementPresent(), "Elements on HomePage should be visible");
    }*/

}

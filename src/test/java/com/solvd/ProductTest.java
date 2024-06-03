package com.solvd;

import com.solvd.constans.SidebarTitle;
import com.solvd.gui.pages.common.*;
import com.solvd.service.ClientService;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductTest extends BaseWebTest {

    @DataProvider(name = "useTestProductQuantityData", parallel=true)
    public Object[][] userRegisterDataProvider() {
        return new Object[][]{
                {"-1"},
                {"abc"},
        };
    }

    @Test(testName = "#TC005", threadPoolSize = 2, invocationCount = 2)
    public void verifyAddProductToCart() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isProductListPresent(), "Products section on homepage is empty");

        homePage.selectRandomProduct();
        String productName = homePage.getSelectedProductName();
        ProductPageBase productPage = homePage.clickSelectedProduct();

        assertEquals(productPage.getProductTitle(), productName, "Product name on product page don't matches selected one");
        //TODO: isProductImageDisplayed()
        assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");

        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();
        assertEquals(cartPage.getProductName(), productName,"The name is not equal to selected product");
        //TODO: getProductPrice()
        assertEquals(cartPage.getProductPrice(), productName,"The price is not equal to selected product");
    }

    @Test(testName= "#TC007", threadPoolSize = 2, invocationCount = 2)
    public void verifyCatalogAndProductPage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isProductListPresent(), "Products section on homepage is empty");

        CatalogPageBase catalogPage =  homePage.getSideMenu().clickMenuButtonByName(String.valueOf(SidebarTitle.CATALOG));
        assertTrue(catalogPage.isProductListPresent(), "Product section on catalog page is empty");

        catalogPage.selectRandomProduct();
        String productName = catalogPage.getSelectedProductName();
        ProductPageBase productPage = catalogPage.clickSelectedProduct();

        //TODO: isProductImageDisplayed()
        assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed");
        assertEquals(productPage.getProductTitle(), productName,
                "Product name on product page don't matches selected one");
    }

    @Test(testName = "#TC008", dataProvider = "useTestProductQuantityData", threadPoolSize = 2, invocationCount = 2)
    public void verifyNegativeValuesNotAllowedInQuantityField(String quantity) {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isProductListPresent(), "Products section on homepage is empty");

        homePage.selectRandomProduct();
        ProductPageBase productPage = homePage.clickSelectedProduct();
        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();
        //TODO: setInputQuantity()
        cartPage.setInputQuantity(quantity);
        assertEquals(cartPage.getInputQuantity(), "1", "The quantity input don't change to 1");
    }

    @Test(testName = "#TC006", threadPoolSize = 2, invocationCount = 2)
    public void verifyCheckoutProcess() {
        ClientService clientService = new ClientService();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isProductListPresent(), "Products section on homepage is empty");

        homePage.selectRandomProduct();
        ProductPageBase productPage = homePage.clickSelectedProduct();
        productPage.clickAddToCartButton();

        CartPageBase cartPage = productPage.getHeader().clickCheckOutLink();

        CheckOutPageBase checkOutPage = cartPage.clickCheckoutButton();
        checkOutPage.fillCheckOutForm(clientService.createClient());
        checkOutPage.clickPayNowButton();

        assertEquals(homePage.getCurrentUrl(), R.TESTDATA.get("URL.base"),
                "User should be redirected to the homepage after payment");
        assertEquals(homePage.isAnyElementPresent(), "Elements on homepage should be visible");
    }
}

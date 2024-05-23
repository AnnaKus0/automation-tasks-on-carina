package com.solvd;

import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.SearchResultPageBase;
import com.solvd.gui.pages.desktop.HomePage;
import com.solvd.util.ScreenshotListener;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners(ScreenshotListener.class)
public class SearchResultPageTest implements IAbstractTest {

    @DataProvider(name = "useTestProductData", parallel=true)
    public Object[][] userRegisterDataProvider() {
        return new Object[][]{
                {"jacket"},
                {"sandals"}
        };
    }

    @Test(testName = "#TC004", dataProvider = "useTestProductData", threadPoolSize = 2, invocationCount = 2)
    public void test_SearchProduct_CheckPresence(String productName) {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        HeaderBase header = homePage.getHeader();

        SearchResultPageBase searchResultPage = header.searchProduct(productName);
        boolean isProductFound = searchResultPage.isProductWithNamePresent(productName);

        assertTrue(isProductFound, "Product with this name is not found on page: " + productName);
    }
}

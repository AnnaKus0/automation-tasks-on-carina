package com.solvd;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.SearchResultPageBase;
import com.solvd.gui.pages.desktop.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

//@Listeners()
public class SearchResultPageTest extends BaseTest {

    @DataProvider(name = "useTestProductData", parallel=true)
    public Object[][] userRegisterDataProvider() {
        return new Object[][]{
                {"jacket"},
        };
    }

    @Test(testName = "#TC004", dataProvider = "useTestProductData", threadPoolSize = 2, invocationCount = 2)
    public void verifySearchFunctionality(String productName) {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        HeaderBase header = homePage.getHeader();

        SearchResultPageBase searchResultPage = header.searchProduct(productName);
        boolean isProductFound = searchResultPage.isProductWithNamePresent(productName);

        assertTrue(isProductFound, "Product with this name is not found on page: " + productName);

    }
}

package com.solvd;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.SearchResultPageBase;
import com.solvd.gui.pages.desktop.HomePage;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchResultPageTest extends BaseTest {

    @DataProvider(name = "useTestProductData", parallel=true)
    public Object[][] userRegisterDataProvider() {
        return new Object[][]{
                {R.TESTDATA.get("PRODUCT.name")},
        };
    }

    @Test(testName = "#TC004", dataProvider = "useTestProductData", threadPoolSize = 2, invocationCount = 2)
    public void verifySearchFunctionality(String productName) {
        HeaderBase header = getHomePage().getHeader();

        SearchResultPageBase searchResultPage = header.searchProduct(productName);
        assertEquals(searchResultPage.getCurrentUrl(), R.TESTDATA.get("URL.search"), "Search page doesn't open");

        boolean isProductFound = searchResultPage.isProductWithNamePresent(productName);
        assertTrue(isProductFound, "Product with this name is not found on page: " + productName);
    }
}

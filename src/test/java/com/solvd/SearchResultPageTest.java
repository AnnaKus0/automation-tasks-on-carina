package com.solvd;

import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchResultPageTest extends BaseTest {

    @DataProvider(name = "useTestProductData", parallel=true)
    public Object[][] userRegisterDataProvider() {
        return new Object[][]{
                {R.TESTDATA.get("PRODUCT.jacket")},
                {R.TESTDATA.get("PRODUCT.sandals")},
        };
    }

    //threadPoolSize = 2, invocationCount = 2
    @Test(testName = "#TC-004", dataProvider = "useTestProductData")
    public void verifySearchFunctionality(String productName) {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        HeaderBase header = homePage.getHeader();
        SearchResultPageBase searchResultPage = header.searchProduct(productName);

        boolean isProductFound = searchResultPage.isProductWithNamePresent(productName);
        assertTrue(isProductFound, "Product with this name is not found on page: " + productName);
    }
}

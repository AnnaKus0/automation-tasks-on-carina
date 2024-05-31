package com.solvd.gui.pages.common;

import com.solvd.constans.URLType;
import com.solvd.gui.components.header.Header;
import com.solvd.gui.pages.desktop.ProductPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ProductPageBase extends AbstractPage {

    private static final Logger logger = LoggerFactory.getLogger(ProductPageBase.class);

    protected ProductPageBase(WebDriver driver) {
        super(driver);
    }

    protected ProductPageBase(WebDriver driver, URLType urlType, String productIdentifier) {
        super(driver);
        String baseUrl = getBaseUrl(urlType);
        setPageURL(baseUrl + productIdentifier);
        logger.info("ProductPage loaded with URL: " + baseUrl + productIdentifier);
    }

    private String getBaseUrl(URLType urlType) {
        return switch (urlType) {
            case HOMEPAGE -> R.TESTDATA.get("URL.product.homepage");
            case COLLECTION -> R.TESTDATA.get("URL.product.collection");
            default -> throw new IllegalArgumentException("Invalid URL type");
        };
    }

    public abstract Header getHeader();

    public abstract boolean isProductImageDisplayed();

    public abstract String getProductTitle();

    public abstract String getProductPrice();

    public abstract void clickAddToCartButton();
}

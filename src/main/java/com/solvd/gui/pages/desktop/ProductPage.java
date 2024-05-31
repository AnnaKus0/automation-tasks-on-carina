package com.solvd.gui.pages.desktop;

import com.solvd.constans.URLType;
import com.solvd.gui.components.header.Header;
import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    private static final Logger logger = LoggerFactory.getLogger(ProductPage.class);

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//section[@id='images']//img[@id='feature-image']")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "//section[@id='buy']//h1[@itemprop='name']")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//section[@id='buy']//h2[@id='product-price']//span[@class='product-price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//section[@id='buy']//input[@id='add' and @type='submit']")
    private ExtendedWebElement addToCartButton;

    public ProductPage(WebDriver driver, URLType urlType, String productIdentifier) {
        super(driver);
        String baseUrl = getBaseUrl(urlType);
        setPageURL(baseUrl + productIdentifier);
        logger.info("ProductPage loaded with URL: " + baseUrl + productIdentifier);
    }

    @Override
    protected String getBaseUrl(URLType urlType) {
        switch (urlType) {
            case HOMEPAGE:
                return R.TESTDATA.get("URL.product.homepage");
            case COLLECTION:
                return R.TESTDATA.get("URL.product.collection");
            default:
                throw new IllegalArgumentException("Invalid URL type");
        }
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public boolean isProductImageDisplayed() {
        return productImage.isVisible();
    }

    @Override
    public String getProductTitle() {
        return productTitle.getText();
    }

    @Override
    public String getProductPrice() {
        return productPrice.getText();
    }

    @Override
    public void clickAddToCartButton() {
        addToCartButton.click();
    }

}

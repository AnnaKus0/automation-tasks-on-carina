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

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage(WebDriver driver, URLType urlType, String productIdentifier) {
        super(driver, urlType, productIdentifier);
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

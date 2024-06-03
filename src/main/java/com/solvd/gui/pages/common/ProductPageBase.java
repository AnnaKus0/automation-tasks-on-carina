package com.solvd.gui.pages.common;

import com.solvd.gui.components.header.Header;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ProductPageBase extends AbstractPage {

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//section[@id='buy']//h1[@itemprop='name']")
    private ExtendedWebElement productTitle;

    @FindBy(id = "product-price")
    private ExtendedWebElement productPrice;

    @FindBy(id = "add")
    private ExtendedWebElement addToCartButton;

    protected ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}

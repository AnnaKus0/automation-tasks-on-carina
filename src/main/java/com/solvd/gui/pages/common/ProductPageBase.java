package com.solvd.gui.pages.common;

import com.solvd.constans.URLType;
import com.solvd.gui.components.header.Header;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class ProductPageBase extends AbstractPage {

    protected ProductPageBase(WebDriver driver) {
        super(driver);
    }

    protected abstract String getBaseUrl(URLType urlType);

    public abstract Header getHeader();

    public abstract boolean isProductImageDisplayed();

    public abstract String getProductTitle();

    public abstract String getProductPrice();

    public abstract void clickAddToCartButton();
}

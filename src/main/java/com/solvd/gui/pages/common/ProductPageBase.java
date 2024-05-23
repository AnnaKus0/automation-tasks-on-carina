package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class ProductPageBase extends AbstractPage {

    protected ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductImageDisplayed();

    public abstract String getProductTitle();

    public abstract String getProductPrice();

    public abstract void clickAddToCartButton();
}

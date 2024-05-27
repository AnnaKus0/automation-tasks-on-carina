package com.solvd.gui.components.product_card;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductCardBase extends AbstractUIObject {

    protected ProductCardBase(WebDriver driver) {
        super(driver);
    }

    protected ProductCardBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getProductName();

    public abstract String getProductPrice();

    public abstract boolean isProductImageDisplayed();

    public abstract void clickOnProduct();
}

package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {

    protected CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductImageDisplayed();

    public abstract String getProductName();

    public abstract String getProductPrice();

    public abstract void setInputQuantity(String quantity);

    public abstract String getInputQuantity();

    public abstract String getTotalPrice();

    public abstract void clickRemoveProductButton();

    public abstract CheckOutPageBase clickCheckoutButton();

}

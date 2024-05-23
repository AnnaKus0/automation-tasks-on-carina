package com.solvd.gui.components.header;

import com.solvd.gui.pages.desktop.CartPage;
import com.solvd.gui.pages.desktop.LoginPage;
import com.solvd.gui.pages.desktop.SearchResultPage;
import com.solvd.gui.pages.desktop.SignUpPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class HeaderBase extends AbstractUIObject {
    protected HeaderBase(WebDriver driver) {
        super(driver);
    }

    public abstract SearchResultPage searchProduct(String productName);

    public abstract LoginPage clickLoginLink();

    public abstract SignUpPage clickSignUpLink();

    public abstract CartPage clickCheckOutLink();

    public abstract boolean isMyAccountLinkVisible();

    public abstract boolean isLogOutLinkVisible();
}

package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.SearchResultPageBase;
import com.solvd.gui.pages.common.SignUpPageBase;
import com.solvd.gui.pages.desktop.CartPage;
import com.solvd.gui.pages.desktop.LoginPage;
import com.solvd.gui.pages.desktop.SearchResultPage;
import com.solvd.gui.pages.desktop.SignUpPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderBase extends AbstractUIObject {

    protected HeaderBase(WebDriver driver) {
        super(driver);
    }

    protected HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract SearchResultPageBase searchProduct(String productName);

    public abstract LoginPageBase clickLoginLink();

    public abstract SignUpPageBase clickSignUpLink();

    public abstract CartPageBase clickCheckOutLink();

    public abstract boolean isMyAccountLinkVisible();

    public abstract boolean isLogOutLinkVisible();
}

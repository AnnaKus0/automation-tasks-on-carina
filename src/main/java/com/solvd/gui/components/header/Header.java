package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.solvd.gui.pages.common.SignUpPageBase;
import com.solvd.gui.pages.desktop.CartPage;
import com.solvd.gui.pages.desktop.LoginPage;
import com.solvd.gui.pages.desktop.SearchResultPage;
import com.solvd.gui.pages.desktop.SignUpPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends HeaderBase implements ICustomTypePageFactory {

    @FindBy(xpath = "//input[@id='search-field']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//a[@id='customer_login_link']")
    private ExtendedWebElement logInLink;

    @FindBy(xpath = "//a[@id='customer_register_link']")
    private ExtendedWebElement signupLink;

    @FindBy(xpath = "//a[contains(@href, '/account') and not(contains(@href, 'logout'))]")
    private ExtendedWebElement myAccountLink;

    @FindBy(xpath = "//a[@id='customer_logout_link']")
    private ExtendedWebElement LogOutLink;

    @FindBy(xpath = "//a[@class='checkout' and @href='/cart']")
    private ExtendedWebElement checkOutLink;

    public Header(WebDriver driver) {
        super(driver);
    }

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchResultPage searchProduct(String productName){
        searchInput.click();
        searchInput.type(productName);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public LoginPageBase clickLoginLink() {
        logInLink.click();
        return initPage(driver, LoginPageBase.class);
    }

    public SignUpPageBase clickSignUpLink() {
        signupLink.click();
        return initPage(driver, SignUpPageBase.class);
    }

    public CartPageBase clickCheckOutLink() {
        checkOutLink.click();
        return initPage(driver, CartPageBase.class);
    }

    public boolean isMyAccountLinkVisible() {
        return myAccountLink.isVisible();
    }

    public boolean isLogOutLinkVisible() {
        return LogOutLink.isVisible();
    }

}

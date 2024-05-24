package com.solvd.gui.components.header;

import com.solvd.gui.pages.desktop.CartPage;
import com.solvd.gui.pages.desktop.LoginPage;
import com.solvd.gui.pages.desktop.SearchResultPage;
import com.solvd.gui.pages.desktop.SignUpPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class Header extends HeaderBase {

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

    public SearchResultPage searchProduct(String productName){
        searchInput.click();
        searchInput.type(productName);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public LoginPage clickLoginLink() {
        logInLink.click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpLink() {
        signupLink.click();
        return new SignUpPage(driver);
    }

    public CartPage clickCheckOutLink() {
        checkOutLink.click();
        return new CartPage(driver);
    }

    public boolean isMyAccountLinkVisible() {
        return myAccountLink.isVisible();
    }

    public boolean isLogOutLinkVisible() {
        return LogOutLink.isVisible();
    }

}

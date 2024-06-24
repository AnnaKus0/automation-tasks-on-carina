package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.CartPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Header extends HeaderBase {

    private static final Logger logger = LoggerFactory.getLogger(Header.class);

    @FindBy(xpath = "//a[contains(@href, '/account')]")
    private ExtendedWebElement myAccountLink;

    @FindBy(id = "customer_logout_link")
    private ExtendedWebElement logOutLink;

    @FindBy(xpath = "//a[contains(@class, 'toggle-drawer') and contains(@class, 'desktop')]")
    private ExtendedWebElement checkOutLink;

    public Header(WebDriver driver) {
        super(driver);
    }

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    //TODO: remove
    @Override
    public boolean checkCartQuantity() {
        return false;
    }


    @Override
    public CartPageBase clickCartLink() {
        checkOutLink.click();
        return initPage(driver, CartPageBase.class);
    }

    public boolean isMyAccountLinkVisible() {
        return myAccountLink.isVisible();
    }

    public boolean isLogOutLinkVisible() {
        return logOutLink.isVisible();
    }

}

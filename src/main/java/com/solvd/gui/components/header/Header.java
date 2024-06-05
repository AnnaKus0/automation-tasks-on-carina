package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.SignUpPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HeaderBase.class)
public class Header extends HeaderBase {

    private static final Logger logger = LoggerFactory.getLogger(Header.class);

    @FindBy(xpath = "//a[contains(@href, '/account')]")
    private ExtendedWebElement myAccountLink;

    @FindBy(id = "customer_logout_link")
    private ExtendedWebElement logOutLink;

    @FindBy(xpath = "//a[contains(@class, 'cart) and contains(@class, 'desktop')]")
    private ExtendedWebElement checkOutLink;

    //TODO: remove, mobile
    @FindBy(xpath = "//a[contains(@class, 'cart) and contains(@class, 'mobile')]")
    private ExtendedWebElement cartMobileLink;

    public Header(WebDriver driver) {
        super(driver);
        logger.info("Get header");
    }

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        logger.info("Get header with context");
    }

    public CartPageBase clickCheckOutLink() {
        checkOutLink.click();
        return initPage(driver, CartPageBase.class);
    }

    //TODO: remove, mobile
    public CartPageBase mobileClickCheckOutLink() {
        cartMobileLink.click();
        return initPage(driver, CartPageBase.class);
    }

    public boolean isMyAccountLinkVisible() {
        return myAccountLink.isVisible();
    }

    public boolean isLogOutLinkVisible() {
        return logOutLink.isVisible();
    }

}

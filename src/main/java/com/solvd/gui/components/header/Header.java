package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.SignUpPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.zebrunner.carina.utils.factory.DeviceType.Type.ANDROID_PHONE;
import static com.zebrunner.carina.utils.factory.DeviceType.Type.DESKTOP;

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
        logger.info("Get header");
    }

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        logger.info("Get header with context");
    }

    //TODO: add xpath
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

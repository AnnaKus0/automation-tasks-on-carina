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

    @FindBy(xpath = "//span[@id='cart-target-mobile']/span[@class='count']")
    private ExtendedWebElement cartCount;

    @FindBy(xpath = "//a[contains(@class, 'toggle-drawer') and contains(@class, 'desktop')]")
    private ExtendedWebElement checkOutLink;

    //TODO: remove, mobile
    @FindBy(xpath = "//a[contains(@class, 'cart') and contains(@class, 'mobile')]")
    private ExtendedWebElement cartMobileLink;

    public Header(WebDriver driver) {
        super(driver);
        logger.info("Get header");
    }

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        logger.info("Get header with context");
    }

    //TODO: Cannot resolve method 'getType' in 'DeviceType'
//    public CartPageBase clickCartLink() {
//        switch (DeviceType.getType()) {
//            case DESKTOP:
//                checkOutLink.click();
//                break;
//            case ANDROID_PHONE:
//                cartMobileLink.click();
//                break;
//            default:
//                logger.error("Device type not supported");
//        }
//        return initPage(getDriver(), CartPageBase.class);
//    }

    public CartPageBase clickCartLink() {
        checkOutLink.click();
        return initPage(driver, CartPageBase.class);
    }

    //TODO: remove, mobile
    public CartPageBase mobileClickCartOutLink(){
        cartMobileLink.click();
        return initPage(driver, CartPageBase.class);
    }

    public boolean checkCartQuantity() {
        waitForElementToBeVisible(cartCount.getBy());
        return cartCount.isVisible();
    }

    public boolean isMyAccountLinkVisible() {
        return myAccountLink.isVisible();
    }

    public boolean isLogOutLinkVisible() {
        return logOutLink.isVisible();
    }

}

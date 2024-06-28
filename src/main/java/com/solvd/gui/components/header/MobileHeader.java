package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.CartPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MobileHeader extends HeaderBase {

    @FindBy(xpath = "//a[@class='cart-target-mobile'")
    private ExtendedWebElement cartMobileLink;

    @FindBy(xpath = "//span[@id='cart-target-mobile']")
    private ExtendedWebElement productCartCountMobile;

    public MobileHeader(WebDriver driver) {
        super(driver);
    }

    public MobileHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    //TODO: * change it to check if quantity od products matches added products
    //      * duplication
    @Override
    public boolean isCardQuantityPresent() {
        return productCartCountMobile.isVisible();
    }

    public CartPageBase clickCartLink() {
        cartMobileLink.click();
        return initPage(driver, CartPageBase.class);
    }

    //TODO: add method body
    @Override
    public boolean isMyAccountLinkVisible() {
        return false;
    }

    //TODO: add method body
    @Override
    public boolean isLogOutLinkVisible() {
        return false;
    }


}

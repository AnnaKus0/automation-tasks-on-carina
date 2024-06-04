package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HeaderBase.class)
public class MobileHeader extends HeaderBase {

    @FindBy(id = "cart-target-mobile")
    private ExtendedWebElement cartMobileLink;

    protected MobileHeader(WebDriver driver) {
        super(driver);
    }

    protected MobileHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPageBase clickCheckOutLink() {
        cartMobileLink.click();
        return initPage(driver, CartPageBase.class);
    }

}

package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.CartPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MobileHeader extends HeaderBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileHeader.class);

    @FindBy(xpath = "//a[@class='cart-target-mobile' and contains(text(), 'My Cart)]")
    private ExtendedWebElement cartMobileLink;

    protected MobileHeader(WebDriver driver) {
        super(driver);
        logger.info("Get mobile header");
    }

    protected MobileHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        logger.info("Get mobile header with context");
    }

    public CartPageBase clickCheckOutLink() {
        cartMobileLink.click();
        return initPage(driver, CartPageBase.class);
    }

}

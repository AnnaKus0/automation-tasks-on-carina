package com.solvd.gui.pages.ios;

import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.components.header.MobileHeader;
import com.solvd.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class MobileProductPage extends ProductPageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileProductPage.class);

    @FindBy(xpath = "//header")
    private MobileHeader header;

    @FindBy(id = " //section[@id='images']//img[@class='mobile']")
    private ExtendedWebElement productImage;

    public MobileProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productImage);
        logger.info("MobileProductPage loaded with element: " + productImage);
    }

    @Override
    public HeaderBase getHeader() {
        return header;
    }

}

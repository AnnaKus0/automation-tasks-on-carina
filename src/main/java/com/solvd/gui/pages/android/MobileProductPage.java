package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class MobileProductPage extends ProductPageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileProductPage.class);

    @FindBy(id = " //section[@id='images']//img[@class='mobile']")
    private ExtendedWebElement productImage;

    public MobileProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.TESTDATA.get("URL.product"));
        logger.info("LoginPage loaded with url");
    }

    //TODO: duplicate method
    public boolean isProductImageDisplayed() {
        return productImage.isVisible();
    }

}

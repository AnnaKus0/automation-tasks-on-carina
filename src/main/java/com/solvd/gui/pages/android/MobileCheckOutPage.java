package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.CheckOutPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckOutPageBase.class)
public class MobileCheckOutPage extends CheckOutPageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileCheckOutPage.class);

    public MobileCheckOutPage(WebDriver driver) {
        super(driver);
        setPageURL(R.TESTDATA.get("URL.checkout"));
        logger.info("CheckOutPage loaded");
    }

}

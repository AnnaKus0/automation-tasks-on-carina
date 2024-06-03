package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class MobileLoginPage extends LoginPageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileLoginPage.class);

    public MobileLoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.TESTDATA.get("URL.login"));
        logger.info("LoginPage loaded with url");
    }

}

package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.SignUpPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignUpPageBase.class)
public class MobileSignUpPage extends SignUpPageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileSignUpPage.class);

    public MobileSignUpPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(R.TESTDATA.get("URL.register"));
        logger.info("SignUpPage loaded with url: " + R.TESTDATA.get("URL.register"));
    }

}

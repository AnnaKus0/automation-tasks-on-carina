package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.SignUpPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignUpPageBase.class)
public class SignUpPage extends SignUpPageBase {

    private static final Logger logger = LoggerFactory.getLogger(SignUpPage.class);

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(R.TESTDATA.get("URL.register"));
        logger.info("SignUpPage loaded with url: " + R.TESTDATA.get("URL.register"));
    }

}

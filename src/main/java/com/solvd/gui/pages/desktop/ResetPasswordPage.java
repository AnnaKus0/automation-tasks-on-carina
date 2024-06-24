package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ResetPasswordPageBase.class)
public class ResetPasswordPage extends ResetPasswordPageBase {

    private static final Logger logger = LoggerFactory.getLogger(ResetPasswordPage.class);

    public ResetPasswordPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(R.TESTDATA.get("URL.login"));
        logger.info("ResetPasswordPage loaded with url: " + R.TESTDATA.get("URL.login"));
    }

}

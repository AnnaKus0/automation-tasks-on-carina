package com.solvd.gui.pages.ios;

import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.components.header.MobileHeader;
import com.solvd.gui.pages.common.SignUpPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SignUpPageBase.class)
public class MobileSignUpPage extends SignUpPageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileSignUpPage.class);

    @FindBy(xpath = "//header")
    private MobileHeader header;

    public MobileSignUpPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(R.TESTDATA.get("URL.register"));
        logger.info("MobileSignUpPage loaded with url: " + R.TESTDATA.get("URL.register"));
    }

    @Override
    public HeaderBase getHeader() {
        return header;
    }

}

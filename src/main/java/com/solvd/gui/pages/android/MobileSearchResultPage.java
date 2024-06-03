package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultPageBase.class)
public class MobileSearchResultPage extends SearchResultPageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileSearchResultPage.class);

    public MobileSearchResultPage(WebDriver driver) {
        super(driver);
        setPageURL(R.TESTDATA.get("URL.login"));
        logger.info("SearchResultPage loaded");
    }

}

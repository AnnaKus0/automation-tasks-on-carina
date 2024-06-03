package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CatalogPageBase.class)
public class MobileCatalogPage extends CatalogPageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileCatalogPage.class);

    public MobileCatalogPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.TESTDATA.get("URL.catalog"));
        logger.info("CatalogPage loaded");
    }

}

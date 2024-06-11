package com.solvd.gui.pages.iphone;

import com.solvd.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CatalogPageBase.class)
public class MobileCatalogPage extends CatalogPageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileCatalogPage.class);

    public MobileCatalogPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(R.TESTDATA.get("URL.catalog"));
        logger.info("MobileCatalogPage loaded with url: " + R.TESTDATA.get("URL.catalog"));
    }

}

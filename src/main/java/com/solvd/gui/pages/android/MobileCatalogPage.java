package com.solvd.gui.pages.android;

import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.components.header.MobileHeader;
import com.solvd.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CatalogPageBase.class)
public class MobileCatalogPage extends CatalogPageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileCatalogPage.class);

    @FindBy(xpath = "//header")
    private MobileHeader header;

    public MobileCatalogPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(R.TESTDATA.get("URL.catalog"));
        logger.info("MobileCatalogPage loaded with url: " + R.TESTDATA.get("URL.catalog"));
    }

    @Override
    public HeaderBase getHeader() {
        return header;
    }

}

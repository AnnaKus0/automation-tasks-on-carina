package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase {

    private static final Logger logger = LoggerFactory.getLogger(CatalogPage.class);

    public CatalogPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(R.TESTDATA.get("URL.catalog"));
        logger.info("CatalogPage loaded with url: " + R.TESTDATA.get("URL.catalog"));
    }

}

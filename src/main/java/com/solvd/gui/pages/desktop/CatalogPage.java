package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase {

    private static final Logger logger = LoggerFactory.getLogger(CatalogPage.class);

    @FindBy(xpath = "//header")
    private Header header;

    public CatalogPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(R.TESTDATA.get("URL.catalog"));
        logger.info("CatalogPage loaded with url: " + R.TESTDATA.get("URL.catalog"));
    }

    @Override
    public HeaderBase getHeader() {
        return header;
    }

}

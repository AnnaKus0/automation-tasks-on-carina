package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    private static final Logger logger = LoggerFactory.getLogger(ProductPage.class);

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(id = "feature-image")
    private ExtendedWebElement productImage;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productImage);
        logger.info("ProductPage loaded with element: " + productImage);
    }

    @Override
    public HeaderBase getHeader() {
        return header;
    }
}

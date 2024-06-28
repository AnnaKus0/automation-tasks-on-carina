package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.product_card.ProductCard;
import com.solvd.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchResultPageBase.class)
public class SearchResultPage extends SearchResultPageBase {

    private static final Logger logger = LoggerFactory.getLogger(SearchResultPage.class);

    public SearchResultPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(getSearchResultTextElement());
        logger.info("SearchResultPage loaded with element: " + getSearchResultTextElement().getText());
    }

}

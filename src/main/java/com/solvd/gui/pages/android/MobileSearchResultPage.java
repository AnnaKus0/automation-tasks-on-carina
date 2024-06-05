package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultPageBase.class)
public class MobileSearchResultPage extends SearchResultPageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileSearchResultPage.class);

    @FindBy(xpath = "//h1[text()='Search Results']")
    private ExtendedWebElement searchResultText;

    public MobileSearchResultPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchResultText);
        logger.info("MobileSearchResultPage loaded with element: " + searchResultText.getText());
    }

}

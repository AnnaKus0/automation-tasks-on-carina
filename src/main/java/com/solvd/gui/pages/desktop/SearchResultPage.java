package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.product_card.ProductCard;
import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.solvd.gui.pages.common.SearchResultPageBase;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchResultPageBase.class)
public class SearchResultPage extends SearchResultPageBase {

    private static final Logger logger = LoggerFactory.getLogger(SearchResultPage.class);

    @FindBy(xpath = "//div[@id='page-content']//section[contains(@class, 'product-grid')]")
    private List<ProductCard> productList;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        logger.info("SearchResultPage loaded");
    }

    @Override
    public boolean isProductWithNamePresent(String productName) {
        List<String> actualProductNames = productList.stream()
                .map(ProductCard::getTitle)
                .toList();

        return actualProductNames.stream()
                .anyMatch(name -> name.contains(productName));
    }

}

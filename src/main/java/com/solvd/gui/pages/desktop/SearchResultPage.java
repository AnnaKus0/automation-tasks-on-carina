package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.product_card.ProductCard;
import com.solvd.gui.pages.common.SearchResultPageBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends SearchResultPageBase {

    @FindBy(xpath = "//div[@id='page-content']//section[contains(@class, 'product-grid')]")
    private List<ProductCard> productList;

    public SearchResultPage(WebDriver driver) {
        super(driver);
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

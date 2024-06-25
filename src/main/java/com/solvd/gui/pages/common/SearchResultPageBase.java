package com.solvd.gui.pages.common;

import com.solvd.gui.components.product_card.ProductCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class SearchResultPageBase extends AbstractPage {

    @FindBy(xpath = "//div[@id='page-content']//section[contains(@class, 'product-grid')]")
    private List<ProductCard> productList;

    @FindBy(xpath = "//div[@id='keyword']/span")
    private ExtendedWebElement searchResultText;

    public SearchResultPageBase(WebDriver driver) {
        super(driver);
    }

    public boolean isProductWithNamePresent(String productName) {
        List<String> actualProductNames = productList.stream()
                .map(ProductCard::getTitle)
                .toList();

        return actualProductNames.stream()
                .anyMatch(name -> name.contains(productName));
    }

    public ExtendedWebElement getSearchResultText() {
        return searchResultText;
    }

    public String getResultText() {
        return searchResultText.getText();
    }

}

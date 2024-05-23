package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends SearchResultPageBase {

    @FindBy(xpath = "//div[@id='page-content']//section[contains(@class, 'product-grid')]")
    private List<ExtendedWebElement> productNamesList;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductWithNamePresent(String productName) {
        List<String> actualProductNames = productNamesList.stream()
                .map(ExtendedWebElement::getText)
                .toList();

        return actualProductNames.stream()
                .anyMatch(name -> name.contains(productName));
    }

}

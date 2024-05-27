package com.solvd.gui.components.product_card;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends ProductCardBase {

    @FindBy(xpath = "//div[contains(@class, 'product-card')]//img")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "//div[contains(@class, 'product-card')]//h3")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//div[contains(@class, 'product-card')]//h4")
    private ExtendedWebElement productPrice;

    public ProductCard(WebDriver driver) {
        super(driver);
    }

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public boolean isProductImageDisplayed() {
        return productImage.isVisible();
    }

    public void clickOnProduct() {
        productName.click();
    }
}
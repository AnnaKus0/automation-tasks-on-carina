package com.solvd.gui.components.product_card;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='info']/h3/a")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//div[@class='price desktop']")
    private ExtendedWebElement productPrice;

    public ProductCard(WebDriver driver) {
        super(driver);
    }

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void clickOnProduct() {
        productTitle.click();
    }
}
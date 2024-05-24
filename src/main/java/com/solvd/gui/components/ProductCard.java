package com.solvd.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {

    @FindBy(id = "product-1")
    private ExtendedWebElement productLink;

    @FindBy(xpath = "//div[@class='product-card']//img")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "//div[@class='product-card']//h3")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//div[@class='product-card']//h4")
    private ExtendedWebElement productPrice;

    protected ProductCard(WebDriver driver) {
        super(driver);
    }

    public void clickOnProduct() {
        productLink.click();
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
}
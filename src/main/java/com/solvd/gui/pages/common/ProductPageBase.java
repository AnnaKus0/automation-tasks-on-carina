package com.solvd.gui.pages.common;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.pages.BasePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class ProductPageBase extends BasePage {

    @FindBy(xpath = "//h1[@itemprop='name']")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//h2[@id='product-price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//input[@type='submit' and @value='Add to Cart']")
    private ExtendedWebElement addToCartButton;

    protected ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}

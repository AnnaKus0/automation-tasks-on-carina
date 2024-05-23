package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends ProductPageBase {

    @FindBy(xpath = "//section[@id='images']//img[@id='feature-image']")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "//section[@id='buy']//h1[@itemprop='name']")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//section[@id='buy']//h2[@id='product-price']//span[@class='product-price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//section[@id='buy']//input[@id='add' and @type='submit']")
    private ExtendedWebElement addToCartButton;

    protected ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductImageDisplayed() {
        return productImage.isVisible();
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

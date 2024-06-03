package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class CartPageBase extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'description')]//img")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "//div[contains(@class, 'description')]//h3/a")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//div[contains(@class, 'total')]/span")
    private ExtendedWebElement totalPrice;

    @FindBy(xpath = "//div[contains(@class, 'remove')]/a")
    private ExtendedWebElement removeProductButton;

    @FindBy(xpath = "//input[contains(@id, 'checkout') and @value='Check Out']")
    private ExtendedWebElement checkOutButton;

    protected CartPageBase(WebDriver driver) {
        super(driver);
    }

    public boolean isProductImageDisplayed() {
        return productImage.isVisible();
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText().trim();
    }

    public void clickRemoveProductButton() {
        removeProductButton.click();
    }

    public CheckOutPageBase clickCheckoutButton() {
        checkOutButton.click();
        return initPage(driver, CheckOutPageBase.class);
    }

}

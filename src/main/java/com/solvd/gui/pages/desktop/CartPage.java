package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.CartPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CartPageBase {

    @FindBy(xpath = "//div[contains(@class, 'description')]//img")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "//div[contains(@class, 'description')]//h3/a")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//div[contains(@class, 'price')]")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//div[contains(@class, 'quantity')]//input[contains(@name, 'updates[]')]")
    private ExtendedWebElement quantityInput;

    @FindBy(xpath = "//div[contains(@class, 'total')]/span")
    private ExtendedWebElement totalPrice;

    @FindBy(xpath = "//div[contains(@class, 'remove')]/a")
    private ExtendedWebElement removeProductButton;

    @FindBy(xpath = "//input[contains(@id, 'checkout') and @value='Check Out']")
    private ExtendedWebElement checkOutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductImageDisplayed() {
        return productImage.isVisible();
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText().trim();
    }

    public void setInputQuantity(String quantity) {
        quantityInput.type(quantity);
        quantityInput.sendKeys(Keys.ENTER);
    }

    public String getInputQuantity() {
        return quantityInput.getAttribute("value");
    }

    public String getTotalPrice() {
        return totalPrice.getText().trim();
    }

    public void clickRemoveProductButton() {
        removeProductButton.click();
    }

    public CheckOutPage clickCheckoutButton() {
        checkOutButton.click();
        return new CheckOutPage(driver);
    }
}

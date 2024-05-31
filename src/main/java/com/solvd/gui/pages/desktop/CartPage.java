package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.CheckOutPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);

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
        setPageAbsoluteURL(R.TESTDATA.get("URL.cart"));
        logger.info("CartPage loaded");
    }

    @Override
    public boolean isProductImageDisplayed() {
        return productImage.isVisible();
    }

    @Override
    public String getProductName() {
        return productName.getText();
    }

    @Override
    public String getProductPrice() {
        return productPrice.getText().trim();
    }

    @Override
    public void setInputQuantity(String quantity) {
        quantityInput.type(quantity);
        quantityInput.sendKeys(Keys.ENTER);
    }

    @Override
    public String getInputQuantity() {
        return quantityInput.getAttribute("value");
    }

    @Override
    public String getTotalPrice() {
        return totalPrice.getText().trim();
    }

    @Override
    public void clickRemoveProductButton() {
        removeProductButton.click();
    }

    @Override
    public CheckOutPageBase clickCheckoutButton() {
        checkOutButton.click();
        return initPage(driver, CheckOutPageBase.class);
    }


}

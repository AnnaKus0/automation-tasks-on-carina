package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class CartPageBase extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'description')]//img")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "//div[contains(@class, 'description')]//h3/a")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//div[contains(@class, 'remove')]/a")
    private ExtendedWebElement removeProductButton;

    @FindBy(xpath = "//input[contains(@id, 'checkout') and @value='Check Out']")
    private ExtendedWebElement checkOutButton;

    @FindBy(xpath = "//section[@id='cart']//p")
    private ExtendedWebElement emptyCartMessage;

    protected CartPageBase(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return productName.getText();
    }

    public void clickRemoveProductButton() {
        removeProductButton.click();
    }

    public CheckOutPageBase clickCheckoutButton() {
        checkOutButton.click();
        return initPage(driver, CheckOutPageBase.class);
    }

    public boolean isEmptyCartMessagePresent() {
        return emptyCartMessage.isElementPresent();
    }

    public abstract void setInputQuantity(String quantity);

    public abstract String getInputQuantity();

    public abstract String getProductPrice();


}

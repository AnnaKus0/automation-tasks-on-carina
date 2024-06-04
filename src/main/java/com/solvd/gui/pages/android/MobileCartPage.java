package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class MobileCartPage extends CartPageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileCartPage.class);

    @FindBy(xpath = "//div[contains(@class, 'quantity')]//p[contains(@class, 'mobile')]")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//div[contains(@class, 'quantity')]//input[contains(@id, 'updates_')]")
    private ExtendedWebElement quantityInput;

    public MobileCartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productPrice);
        logger.info("CartPage loaded with element: " + productPrice);
    }

    //TODO: duplicate method
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

}

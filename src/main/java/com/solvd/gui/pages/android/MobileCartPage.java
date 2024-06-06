package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
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
        setUiLoadedMarker(quantityInput);
        logger.info("MobileCartPage loaded with element: " + quantityInput);
    }

    //TODO: duplicate method
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
    public String getProductPrice() {
        return productPrice.getText();
    }

}

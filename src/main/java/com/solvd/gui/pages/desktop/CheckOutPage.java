package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.CatalogPageBase;
import com.solvd.gui.pages.common.CheckOutPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.solvd.model.Client;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckOutPageBase.class)
public class CheckOutPage extends CheckOutPageBase {

    @FindBy(id = "TextField0")
    private ExtendedWebElement firstNameInput;

    @FindBy(id = "TextField1")
    private ExtendedWebElement lastNameInput;

    @FindBy(id = "TextField3")
    private ExtendedWebElement addressInput;

    @FindBy(id = "TextField4")
    private ExtendedWebElement apartmentInput;

    @FindBy(id = "TextField5")
    private ExtendedWebElement postalCodeInput;

    @FindBy(id = "TextField6")
    private ExtendedWebElement cityInput;

    @FindBy(id = "TextField7")
    private ExtendedWebElement phoneInput;

    @FindBy(id  = "number")
    private ExtendedWebElement cardNumberInput;

    @FindBy(id  = "expiry")
    private ExtendedWebElement expirationDateInput;

    @FindBy(id  = "verification_value")
    private ExtendedWebElement securityCodeInput;

    @FindBy(id  = "name")
    private ExtendedWebElement nameCardInput;

    @FindBy(id  = "checkout-pay-button")
    private ExtendedWebElement payNowButton;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void fillCheckOutForm(Client client) {
        firstNameInput.type(client.getFirstName());
        lastNameInput.type(client.getLastName());
        addressInput.type(client.getAddress());
        apartmentInput.type(String.valueOf(client.getApartment()));
        postalCodeInput.type(client.getPostalCode());
        cityInput.type(client.getCity());
        phoneInput.type(client.getPhone());
        cardNumberInput.type(client.getCardNumber());
        expirationDateInput.type(client.getExpirationDate());
        securityCodeInput.type(client.getSecurityCode());
        nameCardInput.type(client.getNameOnCard());
    }

    @Override
    public HomePageBase clickPayNowButton() {
        payNowButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }

}

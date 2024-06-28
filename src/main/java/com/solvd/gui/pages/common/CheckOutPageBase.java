package com.solvd.gui.pages.common;

import com.solvd.model.User;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class CheckOutPageBase extends AbstractPage {

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

    public CheckOutPageBase(WebDriver driver) {
        super(driver);
    }

    public void fillCheckOutForm(User client) {
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

    public HomePageBase clickPayNowButton() {
        payNowButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }

}

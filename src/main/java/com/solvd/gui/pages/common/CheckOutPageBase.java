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

    public void fillCheckOutForm(User user) {
        firstNameInput.type(user.getFirstName());
        lastNameInput.type(user.getLastName());
        addressInput.type(user.getAddress());
        apartmentInput.type(String.valueOf(user.getApartment()));
        postalCodeInput.type(user.getPostalCode());
        cityInput.type(user.getCity());
        phoneInput.type(user.getPhone());
        cardNumberInput.type(user.getCardNumber());
        expirationDateInput.type(user.getExpirationDate());
        securityCodeInput.type(user.getSecurityCode());
        nameCardInput.type(user.getNameOnCard());
    }

    public HomePageBase clickPayNowButton() {
        payNowButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }

}

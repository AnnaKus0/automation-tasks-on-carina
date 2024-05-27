package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.SearchResultPageBase;
import com.solvd.gui.pages.common.SignUpPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignUpPageBase.class)
public class SignUpPage extends SignUpPageBase {

    @FindBy(id = "first_name")
    private ExtendedWebElement firstNameInput;

    @FindBy(id = "last_name")
    private ExtendedWebElement lastNameInput;

    @FindBy(id = "email")
    private ExtendedWebElement emailAddressInput;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit' and @value='Create']")
    private ExtendedWebElement createButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void fillSignUpForm(String firstName, String lastName, String email, String password) {
        firstNameInput.type(firstName);
        lastNameInput.type(lastName);
        emailAddressInput.type(email);
        passwordInput.type(password);
    }

    @Override
    public void clickCreateButton() {
        createButton.click();
    }

}

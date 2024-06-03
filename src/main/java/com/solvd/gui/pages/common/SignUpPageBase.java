package com.solvd.gui.pages.common;

import com.solvd.gui.components.header.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class SignUpPageBase extends AbstractPage {

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//input[contains(@id, 'first_name')]")
    private ExtendedWebElement firstNameInput;

    @FindBy(xpath = "//input[contains(@id, 'last_name')]")
    private ExtendedWebElement lastNameInput;

    @FindBy(xpath = "//input[contains(@id, 'email')]")
    private ExtendedWebElement emailAddressInput;

    @FindBy(xpath = "//input[contains(@id, 'password')]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit' and @value='Create']")
    private ExtendedWebElement createButton;

    protected SignUpPageBase(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    public void fillSignUpForm(String firstName, String lastName, String email, String password){
        firstNameInput.click();
        firstNameInput.type(firstName);

        lastNameInput.click();
        lastNameInput.type(lastName);

        emailAddressInput.click();
        emailAddressInput.type(email);

        passwordInput.click();
        passwordInput.type(password);
    }

    public void clickCreateButton() {
        createButton.click();
    }
}

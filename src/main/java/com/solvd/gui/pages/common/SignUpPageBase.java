package com.solvd.gui.pages.common;

import com.solvd.gui.pages.BasePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class SignUpPageBase extends BasePage {

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

    public HomePageBase mobileClickCreateButton() {
        createButton.click();
        return initPage(driver, HomePageBase.class);
    }
}

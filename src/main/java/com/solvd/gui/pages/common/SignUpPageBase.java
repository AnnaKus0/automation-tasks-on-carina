package com.solvd.gui.pages.common;

import com.solvd.gui.pages.BasePage;
import com.solvd.model.User;
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

    public SignUpPageBase(WebDriver driver) {
        super(driver);
    }

    public void fillSignUpForm(User user){
        firstNameInput.click();
        firstNameInput.type(user.getFirstName());

        lastNameInput.click();
        lastNameInput.type(user.getLastName());

        emailAddressInput.click();
        emailAddressInput.type(user.getEmail());

        passwordInput.click();
        passwordInput.type(user.getPassword());
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public HomePageBase mobileClickCreateButton() {
        createButton.click();
        return initPage(driver, HomePageBase.class);
    }
}

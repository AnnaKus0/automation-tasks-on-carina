package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class ResetPasswordPageBase extends AbstractPage {

    @FindBy(id = "recover-email")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@type='submit']")
    private ExtendedWebElement submitButton;

    protected ResetPasswordPageBase(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        emailInput.type(email);
    }

    public LoginPageBase clickSubmitButton() {
        submitButton.click();
        return initPage(driver, LoginPageBase.class);
    }

}

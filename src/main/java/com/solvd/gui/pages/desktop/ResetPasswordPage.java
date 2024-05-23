package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage extends ResetPasswordPageBase {

    @FindBy(id = "recover-email")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@type='submit']")
    private ExtendedWebElement submitButton;

    protected ResetPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeEmail(String email) {
        emailInput.type(email);
    }

    @Override
    public LoginPageBase clickSubmitButton() {
        submitButton.click();
        return new LoginPage(driver);
    }

}

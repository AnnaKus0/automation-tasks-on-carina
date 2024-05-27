package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//div[contains(@id, 'login_email')]//input[@type='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//div[contains(@id, 'login_password')]//input[@type='password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//a[contains(text(), 'Forgot your password?')]")
    private ExtendedWebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@type='submit' and @value='Sign in']")
    private ExtendedWebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void fillLogInForm(String email, String password) {
        emailInput.type(email);
        passwordInput.type(password);
    }

    @Override
    public ResetPasswordPageBase clickForgotPasswordLink() {
        forgotPasswordLink.click();
        return new ResetPasswordPage(driver);
    }

    @Override
    public void clickSignInButton() {
        signInButton.click();
    }

}

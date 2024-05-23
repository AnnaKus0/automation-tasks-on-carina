package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void typeEmail(String email) {
        emailInput.type(email);
    }

    public void typePassword(String password) {
        passwordInput.type(password);
    }

    public ResetPasswordPage clickForgotPasswordLink() {
        forgotPasswordLink.click();
        return new ResetPasswordPage(driver);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

}

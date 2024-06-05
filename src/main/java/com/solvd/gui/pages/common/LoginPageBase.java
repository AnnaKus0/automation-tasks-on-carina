package com.solvd.gui.pages.common;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.pages.BasePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class LoginPageBase extends BasePage {

    @FindBy(xpath = "//div[contains(@id, 'login_email')]//input[@type='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//div[contains(@id, 'login_password')]//input[@type='password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//a[text()='Forgot your password?']")
    private ExtendedWebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@type='submit' and @value='Sign in']")
    private ExtendedWebElement signInButton;

    protected LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public void fillLogInForm(String email, String password) {
        emailInput.type(email);
        passwordInput.type(password);
    }

    public ResetPasswordPageBase clickForgotPasswordLink() {
        forgotPasswordLink.click();
        return initPage(driver, ResetPasswordPageBase.class);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public HomePageBase mobileClickSignInButton() {
        signInButton.click();
        return initPage(driver, HomePageBase.class);
    }

    public boolean isEmailInputPresent() {
        return emailInput.isElementPresent();
    }

}

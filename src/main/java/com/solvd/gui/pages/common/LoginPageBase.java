package com.solvd.gui.pages.common;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.pages.desktop.ResetPasswordPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class LoginPageBase extends AbstractPage {

    @FindBy(id = "//header")
    private Header header;

    @FindBy(id = "customer_email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "customer_password")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//div//a[contains(text(), 'Forgot your password?')]")
    private ExtendedWebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@type='submit' and @value='Sign in']")
    private ExtendedWebElement signInButton;

    protected LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
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

}

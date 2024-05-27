package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    protected LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillLogInForm(String email, String password);

    public abstract ResetPasswordPageBase clickForgotPasswordLink();

    public abstract void clickSignInButton();

}

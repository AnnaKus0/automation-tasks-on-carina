package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.CheckOutPageBase;
import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(xpath = "//div[contains(@id, 'login_email')]//input[@type='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//div[contains(@id, 'login_password')]//input[@type='password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//div[@class='parentClassName']//a[text()='Forgot your password?']\n")
    private ExtendedWebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@type='submit' and @value='Sign in']")
    private ExtendedWebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.TESTDATA.get("URL.login"));
        logger.info("LoginPage loaded");
    }

    @Override
    public void fillLogInForm(String email, String password) {
        emailInput.type(email);
        passwordInput.type(password);
    }

    @Override
    public ResetPasswordPageBase clickForgotPasswordLink() {
        logger.info(forgotPasswordLink.getText());
        forgotPasswordLink.click();
        return initPage(driver, ResetPasswordPageBase.class);
    }

    @Override
    public void clickSignInButton() {
        signInButton.click();
    }

}

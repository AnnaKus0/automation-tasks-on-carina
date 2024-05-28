package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.CheckOutPageBase;
import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
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
//        METHOD BODY FROM SELENIUM TASK:
//        waitForElementToBeVisible(element);
//        logger.info("Sent keys to element: " + element.getText());
//        element.click();
//        element.sendKeys(keys);
        emailInput.type(email, 100);
        passwordInput.type(password, 100);

    }

    @Override
    public ResetPasswordPageBase clickForgotPasswordLink() {
        forgotPasswordLink.click();
        return initPage(driver, ResetPasswordPageBase.class);
    }

    @Override
    public void clickSignInButton() {
        signInButton.click();
    }

}

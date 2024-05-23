package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends ResetPasswordPageBase {

    @FindBy(id = "recover-email")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@type='submit']")
    private ExtendedWebElement submitButton;

    protected ResetPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        emailInput.type(email);
    }

    public LoginPage clickSubmitButton() {
        submitButton.click();
        return new LoginPage(driver);
    }

}

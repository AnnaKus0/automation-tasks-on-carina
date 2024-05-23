package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class ResetPasswordPageBase extends AbstractPage {

    protected ResetPasswordPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeEmail(String email);

    public abstract LoginPageBase clickSubmitButton();

}

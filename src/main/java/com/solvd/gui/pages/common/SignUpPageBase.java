package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignUpPageBase extends AbstractPage {

    protected SignUpPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillSignUpForm(String firstName, String lastName, String email, String password) throws InterruptedException;

    public abstract void clickCreateButton();
}

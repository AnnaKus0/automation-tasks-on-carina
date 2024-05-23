package com.solvd.gui.pages.common;

import com.solvd.gui.pages.desktop.HomePage;
import com.solvd.model.Client;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class CheckOutPageBase extends AbstractPage {

    protected CheckOutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillCheckOutForm(Client client);

    public abstract HomePage clickPayNowButton();

}

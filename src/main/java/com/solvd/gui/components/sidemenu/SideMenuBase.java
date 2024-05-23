package com.solvd.gui.components.sidemenu;

import com.solvd.gui.pages.desktop.CatalogPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class SideMenuBase extends AbstractUIObject {
    protected SideMenuBase(WebDriver driver) {
        super(driver);
    }

    public abstract CatalogPage clickMenuButtonByName(String buttonName);
}

package com.solvd.gui.components.sidemenu;

import com.solvd.gui.pages.common.CatalogPageBase;
import com.solvd.gui.pages.desktop.CatalogPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class SideMenuBase extends AbstractUIObject {

    protected SideMenuBase(WebDriver driver) {
        super(driver);
    }

    protected SideMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract CatalogPageBase clickMenuButtonByName(String buttonName);
}

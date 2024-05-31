package com.solvd.gui.components.sidemenu;

import com.solvd.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class SideMenuBase extends AbstractUIObject implements ICustomTypePageFactory {

    protected SideMenuBase(WebDriver driver) {
        super(driver);
    }

    protected SideMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract CatalogPageBase clickMenuButtonByName(String buttonName);
}

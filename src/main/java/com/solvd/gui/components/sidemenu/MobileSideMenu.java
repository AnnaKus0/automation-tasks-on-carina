package com.solvd.gui.components.sidemenu;

import com.solvd.gui.pages.common.CatalogPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class MobileSideMenu extends SideMenuBase {

    protected MobileSideMenu(WebDriver driver) {
        super(driver);
    }

    protected MobileSideMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CatalogPageBase clickMenuButtonByName(String buttonName) {
        return null;
    }
}

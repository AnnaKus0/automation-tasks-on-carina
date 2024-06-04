package com.solvd.gui.pages.common;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.sidemenu.SideMenu;
import com.solvd.gui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class CatalogPageBase extends BasePage {

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//sidebar")
    private SideMenu sideMenu;

    protected CatalogPageBase(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    public SideMenu getSideMenu() {
        return sideMenu;
    }

}

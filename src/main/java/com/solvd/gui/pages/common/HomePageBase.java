package com.solvd.gui.pages.common;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.sidemenu.SideMenu;
import com.solvd.gui.pages.BasePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;


public abstract class HomePageBase extends BasePage {

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//sidebar")
    private SideMenu sideMenu;

    protected HomePageBase(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    public SideMenu getSideMenu() {
        return sideMenu;
    }

}

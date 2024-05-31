package com.solvd.gui.components.sidemenu;

import com.solvd.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SideMenu extends SideMenuBase {

    private static final Logger logger = LoggerFactory.getLogger(SideMenu.class);

    @FindBy(xpath = "//ul[@id='main-menu']//li")
    private List<ExtendedWebElement> sidebarButtons;

    public SideMenu(WebDriver driver) {
        super(driver);
    }

    public SideMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CatalogPageBase clickMenuButtonByName(String buttonName) {
        sidebarButtons.stream()
                .filter(button -> button.getText().equalsIgnoreCase(buttonName))
                .findFirst()
                .ifPresent(ExtendedWebElement::click);

        return initPage(driver, CatalogPageBase.class);
    }
}

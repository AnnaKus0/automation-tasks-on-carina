package com.solvd.gui.components.sidemenu;

import com.solvd.gui.pages.desktop.CatalogPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class SideMenu extends SideMenuBase {

    private static final Logger logger = LoggerFactory.getLogger(SideMenu.class);

    @FindBy(xpath = "//ul[@id='main-menu']/li")
    private List<ExtendedWebElement> sidebarButtons;

    public SideMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CatalogPage clickMenuButtonByName(String buttonName) {
        Optional<ExtendedWebElement> buttonOptional = sidebarButtons.stream()
                .filter(button -> button.getText().equalsIgnoreCase(buttonName))
                .findFirst();

        buttonOptional.ifPresent(button -> {
            logger.info(button.getText());
            button.click();
        });

        return buttonOptional.map(button -> new CatalogPage(driver)).orElse(null);
    }
}

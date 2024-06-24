package com.solvd.gui.pages.common;

import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.components.sidemenu.SideMenu;
import com.solvd.gui.pages.BasePage;
import com.solvd.gui.pages.iphone.MobileHomePage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HomePageBase extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(HomePageBase.class);

    public HomePageBase(WebDriver driver) {
        super(driver);
        logger.info("HomePageBase loaded");
    }

    //TODO: remove clickToggleMenuLink()
    public abstract SideMenu clickToggleMenuLink();

}

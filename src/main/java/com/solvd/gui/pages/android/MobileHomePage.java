package com.solvd.gui.pages.android;

import com.solvd.gui.components.sidemenu.SideMenu;
import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class MobileHomePage extends HomePageBase {

    @FindBy(id = "toggle-menu")
    private ExtendedWebElement toggleMenuLink;

    protected MobileHomePage(WebDriver driver) {
        super(driver);
    }

    public SideMenu clickToggleMenuLink() {
        toggleMenuLink.click();
        return new SideMenu(driver);
    }

}

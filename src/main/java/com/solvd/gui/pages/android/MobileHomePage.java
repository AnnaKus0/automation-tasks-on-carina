package com.solvd.gui.pages.android;

import com.solvd.gui.components.sidemenu.SideMenu;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.desktop.HomePage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class MobileHomePage extends HomePageBase {

    private static final Logger logger = LoggerFactory.getLogger(MobileHomePage.class);

    @FindBy(id = "toggle-menu")
    private ExtendedWebElement toggleMenuLink;

    public MobileHomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(R.TESTDATA.get("URL.base"));
        logger.info("HomePage loaded with url: " + R.TESTDATA.get("URL.base"));
    }

    public SideMenu clickToggleMenuLink() {
        toggleMenuLink.click();
        return new SideMenu(driver);
    }

}

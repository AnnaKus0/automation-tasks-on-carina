package com.solvd;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.desktop.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.config.Configuration;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

public abstract class BaseTest implements IAbstractTest {

    protected String email;

    protected String password;


    @BeforeMethod
    public void setup() {
        email = Configuration.getRequired("USER.email");
        password = Configuration.getRequired("USER.password");
    }

    public HeaderBase getHeader() {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Homepage doesn't open");

        HeaderBase header = homePage.getHeader();
        return header;
    }
}

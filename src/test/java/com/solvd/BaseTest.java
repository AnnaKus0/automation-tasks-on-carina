package com.solvd;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.desktop.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

public abstract class BaseTest implements IAbstractTest {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    protected String email;

    protected String password;

    public void setup() {
        email = Configuration.getRequired("USER.email");
        password = Configuration.getRequired("USER.password");

        logger.info(email);
        logger.info(password);
    }

    public HeaderBase getHeader() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Homepage doesn't open");

        HeaderBase header = homePage.getHeader();
        return header;
    }
}

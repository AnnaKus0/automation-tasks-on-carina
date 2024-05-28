package com.solvd;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.desktop.HomePage;
import com.sun.jdi.connect.spi.TransportService;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.config.Configuration;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.File;
import java.util.Map;
import java.util.Objects;

import static org.testng.Assert.assertTrue;

public abstract class BaseTest implements IAbstractTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected String email;

    protected String password;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        email = Configuration.getRequired("USER.email");
        password = Configuration.getRequired("USER.password");

        logger.info("Browser: " + browser);
        R.CONFIG.put("capabilities.browserName", browser);
    }

    public HomePageBase getHomePage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Homepage doesn't open");
        return homePage;
    }
}

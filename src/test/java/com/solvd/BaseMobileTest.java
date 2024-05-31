package com.solvd;

import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

public abstract class BaseMobileTest implements IAbstractTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseWebTest.class);

    protected String email;

    protected String password;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        email = R.CONFIG.get("USER.email");
        password = R.CONFIG.get("USER.password");

        logger.info("Browser: " + browser);
        R.CONFIG.put("capabilities.browserName", browser);
        R.CONFIG.put("capabilities.deviceName", "Pixel6a");
        R.CONFIG.put("capabilities.udid", "emulator-5554");
    }

    public HomePageBase getHomePage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "HomePage doesn't open");
        return homePage;
    }

    @AfterClass
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}


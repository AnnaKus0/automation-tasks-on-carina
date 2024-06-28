package com.solvd;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public abstract class BaseTest implements IAbstractTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected String email;

    protected String password;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("") String browser) {
        email = R.CONFIG.get("USER.email");
        password = R.CONFIG.get("USER.password");
        logger.info("Browser: " + browser);
        R.CONFIG.put("capabilities.browserName", browser);
    }

    @AfterClass
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}

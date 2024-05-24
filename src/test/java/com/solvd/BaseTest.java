package com.solvd;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAbstractTest {

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser, ITestContext context) {
        WebDriver driver = getDriver();
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("browserName", browser);
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void teardown() {
       getDriver().quit();
    }
}

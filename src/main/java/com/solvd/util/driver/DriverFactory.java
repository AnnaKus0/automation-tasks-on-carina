package com.solvd.util.driver;

import com.solvd.exception.BrowserNotSupportedException;
import com.solvd.util.driver.impl.ChromeDriverManager;
import com.solvd.util.driver.impl.EdgeDriverManager;
import com.solvd.util.driver.impl.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    public static WebDriver createDriver(String browser, String url) {
        DriverManager driverManager;
        try {
            switch (browser.toLowerCase()) {
                case "firefox":
                    driverManager = new FirefoxDriverManager();
                    break;
                case "chrome":
                    driverManager = new ChromeDriverManager();
                    break;
                case "edge":
                    driverManager = new EdgeDriverManager();
                    break;
                default:
                    logger.error("Unsupported browser: " + browser);
                    throw new BrowserNotSupportedException("Unsupported browser: " + browser);
            }
            return driverManager.createDriver(url);
        } catch (IllegalArgumentException e) {
            logger.error("Failed to create driver for browser: " + browser, e);
            throw new BrowserNotSupportedException("Failed to create driver for browser: " + browser, e);
        }
    }
}
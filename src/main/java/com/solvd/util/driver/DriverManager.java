package com.solvd.util.driver;

import org.openqa.selenium.WebDriver;

public interface DriverManager {

    WebDriver createDriver(String url);

}
package com.solvd.gui.pages.common;

import com.solvd.gui.pages.desktop.ProductPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CatalogPageBase extends AbstractPage {

    protected CatalogPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPage clickOnProductByName(String productName);

}

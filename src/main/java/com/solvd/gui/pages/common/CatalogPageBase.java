package com.solvd.gui.pages.common;

import com.solvd.gui.pages.desktop.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public abstract class CatalogPageBase extends AbstractPage {

    protected CatalogPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductListPresent();

    public abstract ProductPageBase clickRandomProduct();

}

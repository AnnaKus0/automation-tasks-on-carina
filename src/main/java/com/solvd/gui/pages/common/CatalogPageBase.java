package com.solvd.gui.pages.common;

import com.solvd.gui.pages.BasePage;
import com.solvd.gui.pages.desktop.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public abstract class CatalogPageBase extends BasePage {

    protected CatalogPageBase(WebDriver driver) {
        super(driver);
    }

}

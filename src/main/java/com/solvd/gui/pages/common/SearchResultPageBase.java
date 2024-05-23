package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class SearchResultPageBase extends AbstractPage {

    protected SearchResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductWithNamePresent(String productName);

}

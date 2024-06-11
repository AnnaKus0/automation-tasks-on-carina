package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.desktop.SearchResultPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class HeaderBase extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//input[@id='search-field']")
    private ExtendedWebElement searchInput;

    protected HeaderBase(WebDriver driver) {
        super(driver);
    }

    protected HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchResultPage searchProduct(String productName){
        searchInput.click();
        searchInput.type(productName);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public abstract boolean checkCartQuantity();

    public abstract CartPageBase clickCartLink();

    public abstract boolean isMyAccountLinkVisible();

    public abstract boolean isLogOutLinkVisible();

}

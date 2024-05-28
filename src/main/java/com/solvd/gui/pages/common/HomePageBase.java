package com.solvd.gui.pages.common;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.product_card.ProductCard;
import com.solvd.gui.components.sidemenu.SideMenu;
import com.solvd.gui.pages.desktop.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import java.util.Random;


public abstract class HomePageBase extends AbstractPage {

    protected HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Header getHeader();

    public abstract  SideMenu getSideMenu();

    public abstract boolean isProductListPresent();

    public abstract ProductPageBase clickRandomProduct();
}

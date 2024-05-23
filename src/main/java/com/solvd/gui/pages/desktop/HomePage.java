package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.sidemenu.SideMenu;
import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

public class HomePage extends HomePageBase {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//sidebar")
    private SideMenu sideMenu;

    @FindBy(xpath = "//section[contains(@class, 'product-grid')]//div[contains(@class, 'columns')]")
    private List<ExtendedWebElement> productList;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("base"));
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public SideMenu getSideMenu() {
        return sideMenu;
    }


    public ExtendedWebElement chooseRandomProduct() {
        Random rand = new Random();
        int lengthOfProductList = productList.size();
        int randomIndex = rand.nextInt(lengthOfProductList);

        ExtendedWebElement randomProduct = productList.stream()
                .skip(randomIndex)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product list is empty"));

        String selectedProductName = randomProduct.getText();
        logger.info(selectedProductName);

        return randomProduct;
    }

    public ProductPage clickSelectedProduct() {
        WebElement product = chooseRandomProduct();
        product.click();
        return new ProductPage(driver);
    }

    public String getSelectedProductName() {
        WebElement product = chooseRandomProduct();
        return product.getText();
    }


}

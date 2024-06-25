package com.solvd.gui.pages;

import com.solvd.exception.ProductNotFound;
import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.components.product_card.ProductCard;
import com.solvd.gui.components.sidemenu.SideMenu;
import com.solvd.gui.pages.common.ProductPageBase;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public abstract class BasePage extends AbstractPage {

    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    @FindBy(xpath = "//sidebar")
    private SideMenu sideMenu;

    @FindBy(xpath = "//section[contains(@class, 'product-grid')]/div[contains(@class, 'four columns')]")
    private List<ProductCard> productList;

    private ProductCard selectedProduct;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public SideMenu getSideMenu() {
        return sideMenu;
    }

    public boolean isProductListPresent() {
        return !productList.isEmpty();
    }

    public ProductCard selectRandomProduct() {
        if (isProductListPresent()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(productList.size());

            ProductCard randomProduct = productList.stream()
                    .skip(randomIndex)
                    .findFirst()
                    .orElseThrow(() -> new ProductNotFound("Unable to find product"));

            this.selectedProduct = randomProduct;
            return randomProduct;
        } else {
            throw new ProductNotFound("Product list is empty");
        }
    }

    public String getSelectedProductName() {
        return selectedProduct.getProductTitle();
    }

    public String getSelectedProductPrice() {
        return selectedProduct.getProductPrice();
    }

    public ProductPageBase clickSelectedProduct() {
        selectedProduct.clickOnProduct();
        return initPage(getDriver(), ProductPageBase.class);
    }

    public abstract HeaderBase getHeader();

}

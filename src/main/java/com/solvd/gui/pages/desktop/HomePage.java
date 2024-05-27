package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.product_card.ProductCard;
import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.sidemenu.SideMenu;
import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class HomePage extends HomePageBase {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//sidebar")
    private SideMenu sideMenu;

    @FindBy(xpath = "//section[@class='product-grid']//div[contains(@class, 'columns')]")
    private List<ProductCard> productList;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL(Configuration.getRequired("URL.base"));
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public SideMenu getSideMenu() {
        return sideMenu;
    }

    @Override
    public ProductCard selectRandomProduct() {
        if (productList.isEmpty()) {
            logger.error("Product list is empty");
            return null;
        }
        Random rand = new Random();
        int lengthOfProductList = productList.size();
        int randomIndex = rand.nextInt(lengthOfProductList);

        ProductCard randomProduct = productList.stream()
                .skip(randomIndex)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product list is empty"));

        String selectedProductName = randomProduct.getTitle();
        logger.info(selectedProductName);

        return randomProduct;
    }

    @Override
    public ProductPage clickSelectedProduct() {
        ProductCard product = selectRandomProduct();
        product.clickOnProduct();
        return new ProductPage(driver);
    }

    @Override
    public String getSelectedProductName() {
        ProductCard product = selectRandomProduct();
        return product.getTitle();
    }

}

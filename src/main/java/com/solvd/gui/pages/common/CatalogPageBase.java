package com.solvd.gui.pages.common;

import com.solvd.gui.pages.desktop.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public abstract class CatalogPageBase extends AbstractPage {

    @FindBy(xpath = "//section[contains(@class, 'product-grid')]/div[contains(@class, 'four columns')]")
    private List<ExtendedWebElement> productList;

    private ExtendedWebElement selectedProduct;

    protected CatalogPageBase(WebDriver driver) {
        super(driver);
    }

    public boolean isProductListPresent() {
        return !productList.isEmpty();
    }

    public ExtendedWebElement selectRandomProduct() {
        if (isProductListPresent()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(productList.size());

            ExtendedWebElement randomProduct = productList.stream()
                    .skip(randomIndex)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Unable to find a random product"));

            this.selectedProduct = randomProduct;
            return randomProduct;
        } else {
            throw new IllegalStateException("Product list is empty");
        }
    }

    public String getSelectedProductName() {
        return selectedProduct.getText();
    }

    public ProductPageBase clickSelectedProduct() {
        selectedProduct.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

}

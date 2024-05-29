package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.CatalogPageBase;
import com.solvd.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase {

    private static final Logger logger = LoggerFactory.getLogger(CatalogPage.class);

    @FindBy(xpath = "//section[@class='product-grid twelve columns alpha omega']/div[contains(@class, 'four columns')]")
    private List<ExtendedWebElement> productList;

    public CatalogPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("URL.catalog"));
        logger.info("CatalogPage loaded");
    }

    @Override
    public boolean isProductListPresent() {
        return !productList.isEmpty();
    }

    @Override
    public ExtendedWebElement selectRandomProduct() {
        if (isProductListPresent()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(productList.size());

            ExtendedWebElement randomProduct = productList.stream()
                    .skip(randomIndex)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Unable to find a random product"));

            return randomProduct;
        } else {
            throw new IllegalStateException("Product list is empty");
        }
    }

    @Override
    public String getSelectedProductName() {
        ExtendedWebElement product = selectRandomProduct();
        return product.getName();
    }

    @Override
    public ProductPageBase clickSelectedProduct() {
        ExtendedWebElement product = selectRandomProduct();
        product.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

}

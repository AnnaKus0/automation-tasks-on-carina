package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.CatalogPageBase;
import com.solvd.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase {

    private static final Logger logger = LoggerFactory.getLogger(CatalogPage.class);

    @FindBy(xpath = "//section[contains(@class, 'product-grid')]//div[contains(@class, 'columns')]/a")
    private List<ExtendedWebElement> productList;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductPageBase clickOnProductByName(String productName) {
        Optional<ExtendedWebElement> productElement = productList.stream()
                .filter(product -> {
                    String textContent = product.getText();
                    return textContent != null && textContent.toLowerCase().contains(productName.toLowerCase());
                })
                .findFirst();

        if (productElement.isPresent()) {
            productElement.get().click();
            return initPage(driver, ProductPageBase.class);
        } else {
            logger.error("Product with name: " + productName + " not found");
            return null;
        }
    }


}

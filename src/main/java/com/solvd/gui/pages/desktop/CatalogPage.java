package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class CatalogPage extends CatalogPageBase {

    private static final Logger logger = LoggerFactory.getLogger(CatalogPage.class);

    @FindBy(xpath = "//section[contains(@class, 'product-grid')]//div[contains(@class, 'columns')]/a")
    private List<ExtendedWebElement> productList;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickOnProductByName(String productName) {
        Optional<ExtendedWebElement> productElement = productList.stream()
                .filter(product -> {
                    String textContent = product.getText();
                    return textContent != null && textContent.toLowerCase().contains(productName.toLowerCase());
                })
                .findFirst();

        if (productElement.isPresent()) {
            productElement.get().click();
            return new ProductPage(driver);
        } else {
            logger.error("Product with name: " + productName + " not found");
            return null;
        }
    }



}

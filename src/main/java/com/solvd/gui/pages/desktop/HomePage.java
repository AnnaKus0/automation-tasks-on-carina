package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.sidemenu.SideMenu;
import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
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

    //TODO: get random product
    @Override
    public ProductPage clickOnProductByName(String productName) {
        Random rand = new Random();

        int lengthOfProductList = productList.size();
        int indexOfProduct = rand.nextInt(lengthOfProductList);

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

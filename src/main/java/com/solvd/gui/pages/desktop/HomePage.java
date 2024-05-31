package com.solvd.gui.pages.desktop;

import com.solvd.constans.URLType;
import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.product_card.ProductCard;
import com.solvd.gui.components.sidemenu.SideMenu;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputFilter;
import java.util.List;
import java.util.Random;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    private ExtendedWebElement selectedProduct;

    @FindBy(id = "//header")
    private Header header;

    @FindBy(id = "sidebar")
    private SideMenu sideMenu;

    //TODO: change ExtendedWebElement to ProductCard
    @FindBy(xpath = "//section[contains(@class, 'product-grid')]/div[contains(@class, 'four columns')]")
    private List<ExtendedWebElement> productList;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(R.TESTDATA.get("URL.base"));
        logger.info("HomePage loaded with url");
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

            this.selectedProduct = randomProduct;
            return randomProduct;
        } else {
            throw new IllegalStateException("Product list is empty");
        }
    }

    @Override
    public String getSelectedProductName() {
        //TODO: remove getText().split("£")[0].strip();
        return selectedProduct.getText().split("£")[0].strip();
    }

    @Override
    public ProductPageBase clickSelectedProduct(URLType urlType, String productIdentifier) {
        selectedProduct.click();
        return initPage(getDriver(), ProductPageBase.class, urlType, productIdentifier);
    }

}


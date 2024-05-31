package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.SearchResultPageBase;
import com.solvd.gui.pages.common.SignUpPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignUpPageBase.class)
public class SignUpPage extends SignUpPageBase {

    private static final Logger logger = LoggerFactory.getLogger(SignUpPage.class);

    @FindBy(xpath = "//input[contains(@id, 'first_name')]")
    private ExtendedWebElement firstNameInput;

    @FindBy(xpath = "//input[contains(@id, 'last_name')]")
    private ExtendedWebElement lastNameInput;

    @FindBy(xpath = "//input[contains(@id, 'email')]")
    private ExtendedWebElement emailAddressInput;

    @FindBy(xpath = "//input[contains(@id, 'password')]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit' and @value='Create']")
    private ExtendedWebElement createButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.TESTDATA.get("URL.register"));
        logger.info("SignUpPage loaded");
    }

    @Override
    public void fillSignUpForm(String firstName, String lastName, String email, String password) throws InterruptedException {
        //::before ::after pseudo-elements

        //waitForElementToAppear(firstNameInput.getBy(), 10);
        firstNameInput.click();
        firstNameInput.type(firstName);

        //waitForElementToAppear(lastNameInput.getBy(), 10);
        lastNameInput.click();
        lastNameInput.type(lastName);

        //waitForElementToAppear(emailAddressInput.getBy(), 10);
        emailAddressInput.click();
        emailAddressInput.type(email);

        //waitForElementToAppear(passwordInput.getBy(), 10);
        passwordInput.click();
        passwordInput.type(password);
    }

//    public void waitForElementToAppear(By locator, int timeout) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//        wait.until((WebDriver driver) -> {
//            WebElement element = driver.findElement(locator);
//            return element != null && element.isDisplayed();
//        });
//    }


    @Override
    public void clickCreateButton() {
        createButton.click();
    }

}

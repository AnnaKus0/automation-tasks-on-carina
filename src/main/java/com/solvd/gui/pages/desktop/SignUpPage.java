package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.SearchResultPageBase;
import com.solvd.gui.pages.common.SignUpPageBase;
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
        setUiLoadedMarker(firstNameInput);
        logger.info("SignUpPage loaded");
    }

    @Override
    public void fillSignUpForm(String firstName, String lastName, String email, String password){
        //::before or ::after pseudo-elements

        waitUntil(ExpectedConditions.visibilityOfElementLocated(firstNameInput.getBy()), 30);
        firstNameInput.click();
        firstNameInput.type(firstName);

        waitUntil(ExpectedConditions.visibilityOfElementLocated(lastNameInput.getBy()), 30);
        lastNameInput.click();
        lastNameInput.type(lastName);

        waitUntil(ExpectedConditions.visibilityOfElementLocated(emailAddressInput.getBy()), 30);
        emailAddressInput.click();
        emailAddressInput.type(email);

        waitUntil(ExpectedConditions.visibilityOfElementLocated(passwordInput.getBy()), 30);
        passwordInput.click();
        passwordInput.type(password);
    }

    @Override
    public void clickCreateButton() {
        createButton.click();
    }

}

package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.SearchResultPageBase;
import com.solvd.gui.pages.common.SignUpPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
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
    }

    @Override
    public void fillSignUpForm(String firstName, String lastName, String email, String password){
//        METHOD BODY FROM SELENIUM TASK:
//        waitForElementToBeVisible(element);
//        logger.info("Sent keys to element: " + element.getText());
//        element.click();
//        element.sendKeys(keys);

        firstNameInput.clickIfPresent();
        firstNameInput.type(firstName);

        lastNameInput.clickIfPresent();
        lastNameInput.type(lastName);

        emailAddressInput.clickIfPresent();
        emailAddressInput.type(email);

        passwordInput.clickIfPresent();
        passwordInput.type(password);
    }

    @Override
    public void clickCreateButton() {
        createButton.click();
    }

}

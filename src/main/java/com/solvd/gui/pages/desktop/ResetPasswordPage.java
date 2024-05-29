package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.ProductPageBase;
import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ResetPasswordPageBase.class)
public class ResetPasswordPage extends ResetPasswordPageBase {

    private static final Logger logger = LoggerFactory.getLogger(ResetPasswordPage.class);

    @FindBy(id = "recover-email")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@type='submit']")
    private ExtendedWebElement submitButton;

    public ResetPasswordPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("URL.login"));
        logger.info("ResetPasswordPage loaded");
    }

    @Override
    public void typeEmail(String email) {
        emailInput.type(email);
    }

    @Override
    public LoginPageBase clickSubmitButton() {
        submitButton.click();
        return initPage(driver, LoginPageBase.class);
    }

}

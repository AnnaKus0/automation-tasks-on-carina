package com.solvd;

import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.solvd.gui.pages.common.SignUpPageBase;
import com.solvd.gui.pages.desktop.HomePage;
import com.solvd.util.ScreenshotListener;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.solvd.util.TestDataGenerator.generateRandomEmail;
import static com.solvd.util.TestDataGenerator.generateRandomString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(ScreenshotListener.class)
public class UserAccountTest implements IAbstractTest {

    @DataProvider(name = "useTestDataSignUp", parallel=true)
    public Object[][] userSignUpDataProvider() {
        return new Object[][]{
                {generateRandomString(), generateRandomString(), generateRandomEmail(), "Pass123"}
        };
    }

    @Test(testName = "#TC001", dataProvider = "useTestDataSignUp", threadPoolSize = 2, invocationCount = 2)
    public void verifyAccountCreation(String firstName, String lastName, String email, String password) {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        HeaderBase header = homePage.getHeader();

        SignUpPageBase signUpPage = header.clickSignUpLink();
        signUpPage.fillSignUpForm(firstName, lastName, email, password);
        signUpPage.clickCreateButton();

        assertTrue(header.isMyAccountLinkVisible(), "My Account link is not visible after account creation");
        assertTrue(header.isLogOutLinkVisible(), "Log Out link is not visible after account creation");
    }

    @Test(testName = "#TC002", threadPoolSize = 2, invocationCount = 2)
    public void verifyUserLogin() {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        HeaderBase header = homePage.getHeader();

        LoginPageBase loginPage = header.clickLoginLink();

        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        loginPage.clickSignInButton();

        assertTrue(header.isMyAccountLinkVisible(), "My Account link is not visible");
        assertTrue(header.isLogOutLinkVisible(), "Log Out link is not visible");
    }

    @Test(testName = "#TC003", threadPoolSize = 2, invocationCount = 2)
    public void verifyResetPassword() {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        HeaderBase header = homePage.getHeader();

        LoginPageBase loginPage = header.clickLoginLink();
        ResetPasswordPageBase resetPasswordPage =  loginPage.clickForgotPasswordLink();
        resetPasswordPage.typeEmail(email);
        resetPasswordPage.clickSubmitButton();

        assertEquals(getDriver().getCurrentUrl(), loginUrl, "The current URL should be login page");
    }

}

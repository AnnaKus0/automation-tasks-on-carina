package com.solvd;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.solvd.gui.pages.common.SignUpPageBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.solvd.util.TestDataGenerator.generateRandomEmail;
import static com.solvd.util.TestDataGenerator.generateRandomString;
import static org.testng.Assert.assertTrue;

public class UserAccountTest extends BaseTest {

    @DataProvider(name = "useTestDataSignUp", parallel=true)
    public Object[][] userSignUpDataProvider() {
        return new Object[][]{
                {generateRandomString(), generateRandomString(), generateRandomEmail(), "Pass123"}
        };
    }

    @Test(testName = "#TC-001", dataProvider = "useTestDataSignUp", threadPoolSize = 2, invocationCount = 2)
    public void verifyCreatingUserAccount(String firstName, String lastName, String email, String password){
        SignUpPageBase signUpPage = initPage(getDriver(), SignUpPageBase.class);
        signUpPage.open();
        signUpPage.assertPageOpened();

        signUpPage.fillSignUpForm(firstName, lastName, email, password);
        signUpPage.clickCreateButton();

        Header header = signUpPage.getHeader();
        assertTrue(header.isMyAccountLinkVisible(), "My Account link is not visible after account creation");
        assertTrue(header.isLogOutLinkVisible(), "Log Out link is not visible after account creation");
    }

    @Test(testName = "#TC-002", threadPoolSize = 2, invocationCount = 2)
    public void verifyLoginProcess() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        loginPage.assertPageOpened();

        loginPage.fillLogInForm(email, password);
        loginPage.clickSignInButton();

        Header header = loginPage.getHeader();
        assertTrue(header.isMyAccountLinkVisible(), "My Account link is not visible after account creation");
        assertTrue(header.isLogOutLinkVisible(), "Log Out link is not visible after account creation");
    }

    @Test(testName = "#TC-003")
    public void verifyResetPassword() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        loginPage.assertPageOpened();

        ResetPasswordPageBase resetPasswordPage =  loginPage.clickForgotPasswordLink();
        resetPasswordPage.typeEmail(email);
        resetPasswordPage.clickSubmitButton();

        assertTrue(loginPage.isPageOpened(), "After successful password reset the current page should be login page");
        assertTrue(loginPage.isEmailInputPresent(), "Email input is not visible after successful password reset");
    }

}

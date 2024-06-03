package com.solvd;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.solvd.gui.pages.common.SignUpPageBase;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.solvd.util.TestDataGenerator.generateRandomEmail;
import static com.solvd.util.TestDataGenerator.generateRandomString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserAccountTest extends BaseWebTest {

    @DataProvider(name = "useTestDataSignUp", parallel=true)
    public Object[][] userSignUpDataProvider() {
        return new Object[][]{
                {generateRandomString(), generateRandomString(), generateRandomEmail(), "Pass123"}
        };
    }

    @Test(testName = "#TC001", dataProvider = "useTestDataSignUp", threadPoolSize = 2, invocationCount = 2)
    public void verifyCreatingUserAccount(String firstName, String lastName, String email, String password){
        SignUpPageBase signUpPage = initPage(getDriver(), SignUpPageBase.class);
        //assertEquals(signUpPage.isPageOpened(), "SignUp page doesn't open");

        signUpPage.fillSignUpForm(firstName, lastName, email, password);
        signUpPage.clickCreateButton();

        Header header = signUpPage.getHeader();

        assertTrue(header.isMyAccountLinkVisible(), "My Account link is not visible after account creation");
        assertTrue(header.isLogOutLinkVisible(), "Log Out link is not visible after account creation");
    }

    @Test(testName = "#TC002", threadPoolSize = 2, invocationCount = 2)
    public void verifyLoginProcess() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        //assertEquals(loginPage.isPageOpened(), "Login page doesn't open");

        loginPage.fillLogInForm(email, password);
        loginPage.clickSignInButton();

        Header header = loginPage.getHeader();

        assertTrue(header.isMyAccountLinkVisible(), "My Account link is not visible");
        assertTrue(header.isLogOutLinkVisible(), "Log Out link is not visible");
    }
    @Test(testName = "#TC003")
    public void verifyResetPassword() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        //assertEquals(loginPage.isPageOpened(), "Login page doesn't open");

        ResetPasswordPageBase resetPasswordPage =  loginPage.clickForgotPasswordLink();
        //assertEquals(resetPasswordPage.isPageOpened(), "Login page doesn't open");

        resetPasswordPage.typeEmail(email);
        resetPasswordPage.clickSubmitButton();

        assertTrue(loginPage.isPageOpened(), "After successful password reset the current page should be login page");
    }

}

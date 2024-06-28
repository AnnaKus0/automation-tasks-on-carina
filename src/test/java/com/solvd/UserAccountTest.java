package com.solvd;

import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.pages.common.LoginPageBase;
import com.solvd.gui.pages.common.ResetPasswordPageBase;
import com.solvd.gui.pages.common.SignUpPageBase;
import com.solvd.service.UserService;
import org.testng.annotations.Test;

import static com.solvd.service.UserService.*;
import static org.testng.Assert.assertTrue;

public class UserAccountTest extends BaseTest {

    @Test(description = "#TC-001")
    public void verifyCreatingUserAccount(){
        SignUpPageBase signUpPage = initPage(getDriver(), SignUpPageBase.class);
        signUpPage.open();
        signUpPage.assertPageOpened();

        signUpPage.fillSignUpForm(UserService.generateRandomString(), UserService.generateRandomString(),
                UserService.generateRandomEmail(), UserService.generateRandomPassword());
        signUpPage.clickCreateButton();

        HeaderBase header = signUpPage.getHeader();
        assertTrue(header.isMyAccountLinkVisible(), "My Account link is not visible after account creation");
        assertTrue(header.isLogOutLinkVisible(), "Log Out link is not visible after account creation");
    }

    @Test(description = "#TC-002")
    public void verifyLoginProcess() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        loginPage.assertPageOpened();

        loginPage.fillLogInForm(email, password);
        loginPage.clickSignInButton();

        HeaderBase header = loginPage.getHeader();
        assertTrue(header.isMyAccountLinkVisible(), "My Account link is not visible after account creation");
        assertTrue(header.isLogOutLinkVisible(), "Log Out link is not visible after account creation");
    }

    @Test(description = "#TC-003")
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

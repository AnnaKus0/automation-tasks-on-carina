package com.solvd;

import com.solvd.constans.SidebarTitle;
import com.solvd.gui.components.header.Header;
import com.solvd.gui.pages.common.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.solvd.util.TestDataGenerator.generateRandomEmail;
import static com.solvd.util.TestDataGenerator.generateRandomString;
import static org.testng.Assert.assertTrue;

public class MobileUserAccountTest extends BaseWebTest {

    @DataProvider(name = "useTestDataSignUp", parallel=true)
    public Object[][] userSignUpDataProvider() {
        return new Object[][]{
                {generateRandomString(), generateRandomString(), generateRandomEmail(), "Pass123"}
        };
    }

//    @Test(testName = "#TC001", dataProvider = "useTestDataSignUp")
//    public void verifyCreatingUserAccount(String firstName, String lastName, String email, String password){
//        SignUpPageBase signUpPage = initPage(getDriver(), SignUpPageBase.class);
//        signUpPage.open();
//        signUpPage.assertPageOpened();
//
//        signUpPage.fillSignUpForm(firstName, lastName, email, password);
//        HomePageBase homePageBase = signUpPage.mobileClickCreateButton();
//
//        assertTrue(homePageBase.getSideMenu().checkPresenceOfButton((String.valueOf(SidebarTitle.ACCOUNT))),
//                "My Account link in sidebar is not visible after account creation");
//
//        assertTrue(homePageBase.getSideMenu().checkPresenceOfButton((String.valueOf(SidebarTitle.LOGOUT))),
//                "Logout link in sidebar is not visible after account creation");
//
//    }
//
//    @Test(testName = "#TC002", threadPoolSize = 2, invocationCount = 2)
//    public void verifyLoginProcess() {
//        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
//        loginPage.open();
//        loginPage.assertPageOpened();
//
//        loginPage.fillLogInForm(email, password);
//        HomePageBase homePageBase = loginPage.mobileClickSignInButton();
//
//        assertTrue(homePageBase.getSideMenu().checkPresenceOfButton((String.valueOf(SidebarTitle.ACCOUNT))),
//                "My Account link in sidebar is not visible after account creation");
//
//        assertTrue(homePageBase.getSideMenu().checkPresenceOfButton((String.valueOf(SidebarTitle.LOGOUT))),
//                "Logout link in sidebar is not visible after account creation");
//    }

    @Test(testName = "#TC003")
    public void verifyResetPassword() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        loginPage.assertPageOpened();

//        ResetPasswordPageBase resetPasswordPage =  loginPage.clickForgotPasswordLink();
//        resetPasswordPage.typeEmail(email);
//        resetPasswordPage.clickSubmitButton();
//
//        assertTrue(loginPage.isPageOpened(), "After successful password reset the current page should be login page");
    }

}

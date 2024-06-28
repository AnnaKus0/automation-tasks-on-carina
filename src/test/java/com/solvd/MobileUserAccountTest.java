package com.solvd;

import com.solvd.constans.SidebarTitle;
import com.solvd.gui.pages.common.*;
import org.testng.annotations.Test;

import static com.solvd.service.UserService.generateRandomEmail;
import static com.solvd.service.UserService.generateRandomPassword;
import static com.solvd.service.UserService.generateRandomString;
import static org.testng.Assert.assertTrue;

public class MobileUserAccountTest extends BaseTest {

    @Test(testName = "#TCM-001")
    public void verifyCreatingUserAccount(){
        SignUpPageBase signUpPage = initPage(getDriver(), SignUpPageBase.class);
        signUpPage.open();
        signUpPage.assertPageOpened();

        signUpPage.fillSignUpForm(generateRandomString(), generateRandomString(), generateRandomEmail(), generateRandomPassword());
        HomePageBase homePageBase = signUpPage.mobileClickCreateButton();

        boolean isAccountButtonPresent = homePageBase.clickToggleMenuLink()
                .checkPresenceOfButton((String.valueOf(SidebarTitle.ACCOUNT)));

        boolean isLogInButtonPresent = homePageBase.clickToggleMenuLink()
                .checkPresenceOfButton((String.valueOf(SidebarTitle.LOGOUT)));

        assertTrue(isAccountButtonPresent, "My Account link in sidebar is not visible after account creation");
        assertTrue(isLogInButtonPresent, "Logout link in sidebar is not visible after account creation");
    }

    @Test(testName = "#TCM-002")
    public void verifyLoginProcess() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        loginPage.assertPageOpened();

        loginPage.fillLogInForm(email, password);
        HomePageBase homePageBase = loginPage.mobileClickSignInButton();

        boolean isAccountButtonPresent = homePageBase.clickToggleMenuLink()
                .checkPresenceOfButton((String.valueOf(SidebarTitle.ACCOUNT)));

        boolean isLogInButtonPresent = homePageBase.clickToggleMenuLink()
                .checkPresenceOfButton((String.valueOf(SidebarTitle.LOGOUT)));

        assertTrue(isAccountButtonPresent, "My Account link in sidebar is not visible after login");
        assertTrue(isLogInButtonPresent, "Logout link in sidebar is not visible after login");
    }
}

package com.example.java.testcases;

import com.example.java.base.BaseTest;
import com.example.java.page.DashboardPage;
import com.example.java.page.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.example.java.base.TestListener;

@Listeners({TestListener.class})  // Aktifkan listener untuk screenshot dan Allure
@Epic("Login Tests")
@Feature("Login Functionality")
public class LoginTest extends BaseTest {

    @Story("Valid Login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify login works with valid credentials")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin();
        loginPage.loginAs("Admin", "admin123");

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        boolean isVisible = dashboardPage.isDashboardHeaderVisible();

        Assert.assertTrue(isVisible, "Login failed: Dashboard header not visible.");
    }

    @Story("Invalid Password")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Login with invalid password")
    public void testInvalidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin();
        loginPage.loginAs("Admin", "wrongpass");

        Assert.assertTrue(loginPage.isLoginErrorVisible(), "Error message not shown for invalid password.");
    }

    @Story("Invalid Username")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Login with invalid username")
    public void testInvalidUsername() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin();
        loginPage.loginAs("WrongUser", "admin123");

        Assert.assertTrue(loginPage.isLoginErrorVisible(), "Error message not shown for invalid username.");
    }

    @Story("Empty Credentials")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Login with empty username and password")
    public void testEmptyFields() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin();
        loginPage.loginAs("", "");

        boolean isStillOnLoginPage = loginPage.isLoginButtonVisible();
        Assert.assertTrue(isStillOnLoginPage, "Should remain on login page with empty fields.");
    }
}

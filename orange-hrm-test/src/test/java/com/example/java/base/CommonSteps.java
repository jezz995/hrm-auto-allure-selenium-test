package com.example.java.base;

import org.openqa.selenium.WebDriver;
import com.example.java.page.LoginPage;

public class CommonSteps {
    WebDriver driver;

    public CommonSteps(WebDriver driver){
        this.driver = driver;
    }

    public void loginToDashboard(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogin();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        loginPage.clickButtonLogin();
    }
    
}

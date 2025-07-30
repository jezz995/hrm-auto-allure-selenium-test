package com.example.java.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class LoginPage extends BasePage {
    WebDriverWait wait;

    public LoginPage (WebDriver driver){
        super(driver);
        
    }

    By username = By.cssSelector("input[placeholder='Username']");
    By password = By.cssSelector("input[placeholder='Password']");
    By btnLogin = By.cssSelector("button[type='submit']");
    

    public void navigateToLogin(){
        String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        this.driver.get(URL);
        this.driver.manage().window().maximize();
        //wait for page to open properly
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));

    }

    public void inputUsername(String userName){
        inputHelper.waitAndInput(username, userName);
    }
    public void inputPassword(String pw){
        inputHelper.waitAndInput(password, pw);
    }
    public void clickButtonLogin(){
        clickHelper.waitUntilVisibleAndClick(btnLogin);
    }
    public void loginAs(String username, String password){
        inputUsername(username);
        inputPassword(password);
        clickButtonLogin();
    }
    public boolean isLoginErrorVisible() {
    By errorMsg = By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return error.isDisplayed();
    }  catch (Exception e) {
        return false;
    }
    }
    public boolean isLoginButtonVisible() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin)).isDisplayed();
    } catch (Exception e) {
        return false;
    }
   }
}

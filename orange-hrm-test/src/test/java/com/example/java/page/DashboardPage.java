package com.example.java.page;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class DashboardPage {
    private WebDriver driver;

    // Locators for Dashboard elements
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By pimMenu = By.xpath("//span[text()='PIM']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

public boolean isDashboardHeaderVisible() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement header = wait.until(
            ExpectedConditions.visibilityOfElementLocated(dashboardHeader)
        );
        return header.isDisplayed();
    } catch (TimeoutException e) {
        System.out.println("Dashboard header not visible after login.");
        return false;
    }
}
    public void clickPIMMenu() {
        driver.findElement(pimMenu).click();
    }
}

package com.example.java.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SelectHelper {
    private WebDriver driver;
    private WebDriverWait wait;

    public SelectHelper(WebDriver driver, int defaultTimeout){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
    }

    public void selectByIndex(By locator, int index){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByIndex(index);
    }

    public void selectByValue(By locator, String value){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByValue(value);
    }

}

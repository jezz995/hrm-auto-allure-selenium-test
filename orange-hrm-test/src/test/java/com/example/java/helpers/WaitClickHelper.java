package com.example.java.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitClickHelper {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitClickHelper(WebDriver driver, int defaultTimeout){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
    }

    /** Wait until element is clickable and click it */
    public void waitUntilClickableAndClick(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    /** Wait until element is visible and click it */
    public void waitUntilVisibleAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }

    /** Wait until element is present in the DOM and click it */
    public void waitUntilPresentAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.click();
    }

    /** Wait until element contains specific text, then click it */
    public void waitUntilTextToBePresentAndClick(By locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        WebElement element = driver.findElement(locator);
        element.click();
    }
}

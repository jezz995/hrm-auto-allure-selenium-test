package com.example.java.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage {
    private WebDriver driver;

    // Locators for key PIM elements
    private By addButton = By.xpath("//button[normalize-space()='Add']");
    private By firstNameField = By.name("firstName");
    private By middleNameField = By.name("middleName");
    private By lastNameField = By.name("lastName");
    private By employeeIdField = By.xpath("//label[text()='Employee Id']/../following-sibling::div/input");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");

    public PIMPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterMiddleName(String middleName) {
        driver.findElement(middleNameField).sendKeys(middleName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmployeeId(String empId) {
        driver.findElement(employeeIdField).clear(); // Optional: clear default value
        driver.findElement(employeeIdField).sendKeys(empId);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }

    // High-level method to create an employee
    public void createEmployee(String first, String middle, String last, String empId) {
        clickAddButton();
        enterFirstName(first);
        enterMiddleName(middle);
        enterLastName(last);
        enterEmployeeId(empId);
        clickSave();
    }
}

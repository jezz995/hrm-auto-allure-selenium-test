package com.example.java.base;

import io.qameta.allure.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.example.java.utilities.Screenshot;

public class TestListener implements ITestListener {
    Screenshot screenshot = new Screenshot();

    @Override
    public void onTestStart(ITestResult result) {
        Allure.step("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Allure.step("Test passed: " + result.getName());

        try {
            String ssName = result.getMethod().getMethodName();
            screenshot.takeScreenshot(ssName);
            screenshot.attachScreenshotPNG(ssName);
        } catch (Exception e) {
            System.out.println("Error taking screenshot on test success: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.step("Test failed: " + result.getName());

        try {
            String ssName = result.getMethod().getMethodName() + "_failure";
            screenshot.takeScreenshot(ssName);
            screenshot.attachScreenshotPNG(ssName);
        } catch (Exception e) {
            System.out.println("Error taking screenshot on test failure: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Allure.step("Test skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        Allure.step("Finishing test suite: " + context.getName());
    }
}

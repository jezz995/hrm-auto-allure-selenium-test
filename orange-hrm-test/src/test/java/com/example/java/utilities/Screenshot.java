package com.example.java.utilities;

import com.example.java.base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshot extends BaseTest {
    public void takeScreenshot(String testName) {

        WebDriver driver = getDriver();

        File screenshotFolder =
                new File(System.getProperty("user.dir") +
                        File.separator + "target" + File.separator + "screenshots");
        if (!screenshotFolder.exists()) {
            screenshotFolder.mkdirs();
        }

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Des = new File(screenshotFolder, testName + ".png");
        try {
            Thread.sleep(2000);
            // Optional: wait for 2 seconds before taking the screenshot
            FileHandler.copy(src, Des);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to take screenshot: " + e.getMessage());
        }

    }

    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    public byte[] attachScreenshotPNG(String fileName) throws IOException {
        File screenshotFile = new File(System.getProperty("user.dir") + File.separator + "target" + File.separator + "screenshots" + File.separator + fileName + ".png");
        return java.nio.file.Files.readAllBytes(screenshotFile.toPath());
    }
}

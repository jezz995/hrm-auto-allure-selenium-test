package com.example.java.base;

//import com.example.java.base.CommonSteps;
//import com.example.java.utilities.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected WebDriver driver;
    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        initDriver();
        getDriver().manage().window().maximize();

        //Screenshot.setDriver(getDriver());

 // Hanya login otomatis jika bukan LoginTest
        if (!this.getClass().getSimpleName().equals("LoginTest")) {
        CommonSteps commonSteps = new CommonSteps(getDriver());
        commonSteps.loginToDashboard();
    }
    }

    public void initDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        System.out.println("Launching browser: " + browser);

        switch (browser) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--private");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--inprivate");
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        driverThreadLocal.set(driver);
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}

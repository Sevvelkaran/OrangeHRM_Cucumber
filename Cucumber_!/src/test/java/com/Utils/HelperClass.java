package com.Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {

    private static HelperClass helperClassInstance;
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static final int TIMEOUT = 10;

    // Private constructor to prevent external instantiation
    private HelperClass() {
        try {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");

            driver = new FirefoxDriver(options);
            LogManagers.logInfo("Firefox opened");

            wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
            driver.manage().window().maximize();

            LogManagers.logInfo("Window has been maximized");

        } catch (Exception e) {
            LogManagers.logError("Error while initializing the Firefox WebDriver: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Singleton driver setup
    public static void setUpDriver() {
        if (helperClassInstance == null) {
            synchronized (HelperClass.class) {
                if (helperClassInstance == null) {
                    helperClassInstance = new HelperClass();
                }
            }
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void openPage(String url) {
        try {
            driver.get(url);
            LogManagers.logInfo("Navigated to URL: " + url);
        } catch (Exception e) {
            LogManagers.logError("Failed to open URL: " + url + " - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void teardown() {
        try {
            if (driver != null) {
                driver.quit();
                LogManagers.logInfo("Browser closed successfully");
                driver = null;
            }
            helperClassInstance = null;
        } catch (Exception e) {
            LogManagers.logError("Error during teardown: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

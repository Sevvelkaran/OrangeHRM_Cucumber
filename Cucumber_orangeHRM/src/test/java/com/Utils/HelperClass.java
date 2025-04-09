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
    public final static int TIMEOUT = 10;

    private HelperClass() {
  

        driver = new FirefoxDriver();
       // LogManagers.logInfo("FireFox Opened");

        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
       // LogManagers.logInfo("Window have Been Maximised");

    }

    public static void openPage(String url) {
        driver.get(url);
       // LogManagers.logInfo("Got the URL");

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
        if (helperClassInstance == null) {
            synchronized (HelperClass.class) {  
                if (helperClassInstance == null) {
                    helperClassInstance = new HelperClass();
                }
            }
        }
    }

    public static void teardown() {
        if (driver != null) {
            driver.quit(); 
            driver = null;
        }
        helperClassInstance = null;
    }
}
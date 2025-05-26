package com.Utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    public static final int TIMEOUT = 10;

    public static void setUpDriver() {
    	FirefoxOptions opt = new FirefoxOptions();
      	opt.addArguments("--headless");
        WebDriver localDriver = new FirefoxDriver(opt); 
        driver.set(localDriver);
        
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        localDriver.manage().window().maximize();
        
        wait.set(new WebDriverWait(localDriver, Duration.ofSeconds(TIMEOUT)));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    public static void openPage(String url) {
        getDriver().get(url);
    }

    public static void teardown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            wait.remove();
        }
    }
}

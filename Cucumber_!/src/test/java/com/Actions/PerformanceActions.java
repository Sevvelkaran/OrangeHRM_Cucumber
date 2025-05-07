package com.Actions;

import com.Pages.*;
import com.Utils.HelperClass;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PerformanceActions {

    private WebDriver driver;
    private LoginPages loginPages;
    private PerformancePages performancePages = null;
    private WebDriverWait wait;

    public PerformanceActions() {
        driver = HelperClass.getDriver();
        loginPages = new LoginPages();
        performancePages = new PerformancePages();
        PageFactory.initElements(driver, performancePages);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToPerformanceModule() {
        performancePages.performanceTab.click();
    }

    public void navigateToTrackers() {
        performancePages.configureTab.click();
        performancePages.trackersLink.click();
    }

    public void addTracker(String trackerName, String employeeName, String reviewers) {
        Actions actions = new Actions(driver);

        wait.until(ExpectedConditions.visibilityOf(performancePages.trackerName));
        performancePages.trackerName.sendKeys(trackerName);

        wait.until(ExpectedConditions.visibilityOf(performancePages.employeeName));
        performancePages.employeeName.sendKeys(employeeName);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        wait.until(ExpectedConditions.visibilityOf(performancePages.reviewers));
        performancePages.reviewers.sendKeys(reviewers);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    public boolean isTrackerAddedSuccessfully(String trackerName) {
        String successMessage = performancePages.successMessage.getText();
        return successMessage.contains("Sevvel");
    }

    public void addTrackerWithInvalidData1(String trackerNamee, String employeeNamee, String reviewerss) {
        performancePages.trackerName.sendKeys(trackerNamee);

        if (employeeNamee != null) {
            performancePages.employeeName.sendKeys(employeeNamee);
            performancePages.employeeName.sendKeys(Keys.ENTER);
        }

        
    }

    public void VerifyErrorMessage(String expected) {
        if (performancePages.requiredEmployeeError.isDisplayed()) {
            String actual = performancePages.requiredEmployeeError.getText();
            Assert.assertEquals(actual,expected);
            System.out.println("Required Employee Name");
    }
    }
}
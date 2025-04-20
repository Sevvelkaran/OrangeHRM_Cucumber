package com.Actions;

import com.Pages.*;
import com.Utils.HelperClass;
import junit.framework.Assert;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-autocomplete-option')]")));
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        wait.until(ExpectedConditions.visibilityOf(performancePages.reviewers));
        performancePages.reviewers.sendKeys(reviewers);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-autocomplete-option')]")));
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

        if (reviewerss != null) {
            performancePages.reviewers.sendKeys(reviewerss);
            performancePages.reviewers.sendKeys(Keys.ENTER);
        }
    }

    public void VerifyErrorMessage(String expected) {
        if (performancePages.requiredEmployeeError.isDisplayed()) {
            String actual = performancePages.requiredEmployeeError.getText();
            Assert.assertEquals(expected, actual);
            System.out.println("Required Employee Name");
        } else {
            String actual = performancePages.requiredTrackerError.getText();
            Assert.assertEquals(expected, actual);
            System.out.println("Required Tracker Name");
        }
    }

}
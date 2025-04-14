package com.Actions;

import com.Pages.*;
import com.Pages.PerformancePages;
import com.Utils.HelperClass;

import junit.framework.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PerformanceActions {

    private WebDriver driver;
    private LoginPages loginPages;
    private PerformancePages performancePages=null;

    public PerformanceActions() {
        driver = HelperClass.getDriver();
        loginPages = new LoginPages();
        performancePages = new PerformancePages();
        PageFactory.initElements(driver, performancePages);
    }

    public void navigateToPerformanceModule() {
        performancePages.performanceTab.click();
    }

    public void navigateToTrackers() {
        performancePages.configureTab.click();
        performancePages.trackersLink.click();
    }

    public void addTracker(String trackerName, String employeeName, String reviewers) throws InterruptedException {

        Actions actions = new Actions(driver);

        performancePages.trackerName.sendKeys(trackerName);
        performancePages.employeeName.sendKeys(employeeName);
        Thread.sleep(3000);

        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        performancePages.reviewers.sendKeys(reviewers);
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }
        

    public boolean isTrackerAddedSuccessfully(String trackerName) {
        String successMessage = performancePages.successMessage.getText();
         return successMessage.contains("Sevvel");
    	  
    }
    
    public void addTrackerWithInvalidData1(String trackerNamee, String employeeNamee, String reviewerss) {
    	performancePages.trackerName.sendKeys(trackerNamee);
    	
        if (employeeNamee != null && !employeeNamee.trim().isEmpty() && !employeeNamee.equalsIgnoreCase("[empty]")) {
            performancePages.employeeName.sendKeys(employeeNamee);
            performancePages.employeeName.sendKeys(Keys.ENTER);
        }

//        if (reviewerss != null && !reviewerss.trim().isEmpty() && !reviewerss.equalsIgnoreCase("[empty]")) {
//        	performancePages.reviewers.sendKeys(reviewerss);
//        	performancePages.reviewers.sendKeys(Keys.ENTER);
//        }
    }
     public void VerifyErrorMessage(String expected) {
    	 if(performancePages.requiredEmployeeError.isDisplayed()) {
    	 String actual=performancePages.requiredEmployeeError.getText();
    	 Assert.assertEquals(expected,actual);
    	 System.out.println("Required Employee Name");
    	 }
//    	 else {
//    		 String actual=performancePages.requiredTrackerError.getText();
//        	 Assert.assertEquals(expected,actual);
//        	 System.out.println("Required Tracker Name");
//    	 }
     }
     
    public boolean isEmployeeNameRequiredErrorDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOf(performancePages.requiredEmployeeError)).isDisplayed();
    }
    
    
}
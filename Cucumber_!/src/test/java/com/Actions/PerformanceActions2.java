package com.Actions;

import com.Pages.PerformancePages2;
import com.Utils.HelperClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;



public class PerformanceActions2 {

    WebDriver driver;
    PerformancePages2 pages;
    String parentWindow;

    public PerformanceActions2() {
        driver = HelperClass.getDriver();
        pages = new PerformancePages2();
        PageFactory.initElements(driver, pages);
    }

    public void clickManageReviewsAndSelectMyReviews() {
        pages.manageReviewsLink.click();
        pages.myReviewsLink.click();
    }

    public void verifyCredentials(List<Map<String, String>> data) {
        for (Map<String, String> row : data) {
            String expectedJobTitle = row.get("Job Title");
            String expectedReviewStatus = row.get("Review Status");

            String actualJobTitle = pages.jobTitle.getText().trim();
            String actualReviewStatus = pages.reviewStatus.getText().trim();
             Assert.assertEquals(actualJobTitle, expectedJobTitle, "Job Title does not match");
             Assert.assertEquals(actualReviewStatus, expectedReviewStatus, "Review Status does not match");
             System.out.println("Asserted the Job Title and Review Status");
        }
    }
    
    public void clickMyTrackers() {
        pages.myTrackersLink.click();
    }

    public void verifyMyTrackerName(String expectedName) {
        String actualName = pages.trackerName.getText().trim();
        System.out.println("Expected Tracker: " + expectedName);
        System.out.println("Actual Tracker: " + actualName);
        Assert.assertEquals(actualName, expectedName, "Tracker name doesn't match");
    }
    
    public void clickEmployeeTrackers() {
        pages.employeeTrackersLink.click();
    }

    public void enterEmployeeNameAndInclude(String employeeName) {
        Actions act = new Actions(driver);
        
       
        pages.employeeNameField.click();
        pages.employeeNameField.sendKeys(employeeName);
        act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

    
        pages.includeDropdown.click();
        act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }

    public void clickSearchInEmployeeTrackers() {
        pages.searchButton.click();
    }

    public void verifySearchedEmployee(String expectedName) {
        String actualName = pages.resultEmployeeName.getText().trim();
        System.out.println("Expected Employee: " + expectedName);
        System.out.println("Actual Employee: " + actualName);
        Assert.assertEquals(actualName, expectedName, "Employee name doesn't match");
    }

    public void verifySearchedEmployeeMessage(String expectedMsg) {
        WebElement msg = driver.findElement(By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]"));
        String actualMsg = msg.getText();
        Assert.assertEquals(actualMsg, expectedMsg, "Mismatch in expected and actual error messages.");
    }


    public void clickViewButton() {
        pages.viewBtn.click();
    }
    
    public void clickAddLogButton() {
        pages.addLogBtn.click();

        parentWindow = driver.getWindowHandle(); 
        List<String> allWindows = new ArrayList<>(driver.getWindowHandles());

        for (String handle : allWindows) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle); 
                break;
            }
        }
    }

    public void enterLogDetails(List<Map<String, String>> data) {
        Map<String, String> row = data.get(0);
        pages.logField.sendKeys(row.get("Log"));
        pages.commentField.sendKeys(row.get("Comment"));
    }
    
    public void clickSaveButton() {
        pages.saveBtn.click();  

        driver.switchTo().window(parentWindow);
    }
    
    public void verifyLogAddedSuccessMessage() {
        WebElement successMessage = driver.findElement(By.xpath("(//h6[@class=\"oxd-text oxd-text--h6 orangehrm-employee-tracker-log-title-text\"])[1]"));
        String msg = successMessage.getText();
        Assert.assertTrue(msg.contains("3Hours"), "Log was not added successfully");
    }
 }

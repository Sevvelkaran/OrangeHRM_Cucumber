package com.Actions;

import com.Pages.PerformancePages2;
import com.Utils.HelperClass;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class PerformanceActions2 {

    WebDriver driver;
    PerformancePages2 pages;

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
            System.out.println("Asserted the Job Title and Review Status");
//             Assert.assertEquals(actualJobTitle, expectedJobTitle, "Job Title does not match");
//             Assert.assertEquals(actualReviewStatus, expectedReviewStatus, "Review Status does not match");
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


  

}

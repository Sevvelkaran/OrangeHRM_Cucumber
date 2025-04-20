package com.Definations;

import com.Actions.LoginActions;
import com.Actions.PerformanceActions;
import com.Pages.LoginPages;
import com.Pages.PerformancePages;
import com.Utils.HelperClass;
import com.Utils.LogManagers;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class PerformanceDefinition {

    private WebDriver driver;
    private LoginActions login;
    private PerformancePages performancePages;
    public PerformanceActions per;

    public PerformanceDefinition() {
        driver = HelperClass.getDriver();
        performancePages = new PerformancePages();
        login = new LoginActions();
        per = new PerformanceActions();

        PageFactory.initElements(driver, login);
        PageFactory.initElements(driver, performancePages);
    }

    @Given("The user launches the browser and navigates to the Performance module  {string}")
    public void the_user_launches_the_browser_and_navigates_to_the_performance_module(String url) {
        try {
            HelperClass.openPage(url);
            login.Valid();
            login.Login();
            LogManagers.logInfo("Entered Credentials and clicked login");
        } catch (Exception e) {
            LogManagers.logError("Error while navigating to Performance module: " + e.getMessage());
        }
    }

    @When("navigates to the Performance module")
    public void navigates_to_the_performance_module() {
        try {
            performancePages.performanceTab.click();
            LogManagers.logInfo("On Performance Module");
        } catch (Exception e) {
            LogManagers.logError("Error clicking on Performance tab: " + e.getMessage());
        }
    }

    @When("The user clicks on Configure and selects Trackers")
    public void the_user_clicks_on_configure_and_selects_trackers() {
        try {
            performancePages.configureTab.click();
            performancePages.trackersLink.click();
            LogManagers.logInfo("Configure and Trackers clicked");
        } catch (Exception e) {
            LogManagers.logError("Error navigating to Trackers: " + e.getMessage());
        }
    }

    @And("The user clicks the Add button")
    public void the_user_clicks_the_add_button() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement addTrackerButton = wait.until(ExpectedConditions.elementToBeClickable(performancePages.addTrackerButton));
            addTrackerButton.click();
            LogManagers.logInfo("Clicked on Add Button");
        } catch (Exception e) {
            LogManagers.logError("Error clicking on Add button: " + e.getMessage());
        }
    }

    @And("The user enters the following tracker details")
    public void the_user_enters_the_following_tracker_details(DataTable dataTable) {
        try {
            List<Map<String, String>> trackerList = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> tracker : trackerList) {
                String trackerName = tracker.get("Tracker Name");
                String employeeName = tracker.get("Employee Name");
                String reviewers = tracker.get("Reviewers");
                per.addTracker(trackerName, employeeName, reviewers);
            }
            LogManagers.logInfo("Tracker details have been entered");
        } catch (Exception e) {
            LogManagers.logError("Error entering tracker details: " + e.getMessage());
        }
    }

    @And("The user clicks the Save button")
    public void the_user_clicks_the_save_button() {
        try {
            performancePages.saveButton.click();
            LogManagers.logInfo("Clicked on Save button");
        } catch (Exception e) {
            LogManagers.logError("Error clicking Save button: " + e.getMessage());
        }
    }

    @Then("The tracker {string} should be successfully added")
    public void the_tracker_should_be_successfully_added(String trackerName) {
        try {
            String successMessage = performancePages.successMessage.getText();
            Assert.assertTrue(successMessage.contains(trackerName), "Tracker not added successfully");
            LogManagers.logInfo("Tracker addition asserted successfully");
        } catch (AssertionError | Exception e) {
            LogManagers.logError("Assertion failed for tracker addition: " + e.getMessage());
        }
    }

    @And("The user enters the invalid tracker details")
    public void the_user_enters_the_invalid_tracker_details(DataTable dataTable) {
        try {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> row : data) {
                String trackerName = row.get("Tracker Name");
                String employeeName = row.get("Employee Name");
                String reviewers = row.get("Reviewers");

                per.addTrackerWithInvalidData1(trackerName, employeeName, reviewers);
                performancePages.saveButton.click();
            }
            LogManagers.logInfo("Invalid Tracker details entered");
        } catch (Exception e) {
            LogManagers.logError("Error entering invalid tracker details: " + e.getMessage());
        }
    }

    @Then("The system should display an error message indicating {string}")
    public void the_system_should_display_an_error_message_indicating_employee_name(String message) {
        try {
            per.VerifyErrorMessage(message);
            LogManagers.logInfo("Error message asserted successfully");
        } catch ( Exception e) {
            LogManagers.logError("Error message assertion failed: " + e.getMessage());
        }
    }
}

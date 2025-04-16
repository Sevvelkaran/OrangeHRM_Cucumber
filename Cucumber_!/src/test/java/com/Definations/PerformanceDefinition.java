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
        login = new LoginActions();
        performancePages = new PerformancePages();
        per = new PerformanceActions();
        // Initializing elements using PageFactory
        PageFactory.initElements(driver, login);
        PageFactory.initElements(driver, performancePages);
    }

    // Step to login and navigate to application
    @Given("The user launches the browser and navigates to the Performance module")
    public void the_user_launches_the_browser_and_navigates_to_the_performance_module() {
        login.Valid();
        login.Login();
        LogManagers.logInfo("Entered Credentials and clicked login");
    }

    // Step to click on Performance module
    @When("navigates to the Performance module")
    public void navigates_to_the_performance_module() {
        performancePages.performanceTab.click();
        LogManagers.logInfo("On Performance Module");
    }

    // Step to click Configure and select Trackers
    @When("The user clicks on Configure and selects Trackers")
    public void the_user_clicks_on_configure_and_selects_trackers() {
        performancePages.configureTab.click();
        performancePages.trackersLink.click();
        LogManagers.logInfo("Configure Clicked");
        LogManagers.logInfo("Trackers Clicked");
    }

    // Step to click Add button
    @And("The user clicks the Add button")
    public void the_user_clicks_the_add_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addTrackerButton = wait.until(ExpectedConditions.elementToBeClickable(performancePages.addTrackerButton));
        performancePages.addTrackerButton.click();
        LogManagers.logInfo("Clicked on Add Button");
    }

    // Step to enter valid tracker details using DataTable
    @And("The user enters the following tracker details")
    public void the_user_enters_the_following_tracker_details(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> trackerList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> tracker : trackerList) {
            String trackerName = tracker.get("Tracker Name");
            String employeeName = tracker.get("Employee Name");
            String reviewers = tracker.get("Reviewers");
            per.addTracker(trackerName, employeeName, reviewers);
        }
        LogManagers.logInfo("Trackers details have been entered");
    }

    // Step to click Save button
    @And("The user clicks the Save button")
    public void the_user_clicks_the_save_button() {
        performancePages.saveButton.click();
        LogManagers.logInfo("Clicked on Save button");
    }

    // Step to assert if the tracker was added successfully
    @Then("The tracker {string} should be successfully added")
    public void the_tracker_should_be_successfully_added(String trackerName) {
        String successMessage = performancePages.successMessage.getText();
        assert successMessage.contains(trackerName) : "Tracker not added successfully";
        System.out.println("Successfully Asserted ");
        LogManagers.logInfo("Asserted");
    }

    // Step to enter invalid tracker details
    @And("The user enters the invalid tracker details")
    public void the_user_enters_the_invalid_tracker_details(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String trackerName = data.get(0).get("Tracker Name");
            String employeeName = data.get(0).get("Employee Name");
            String reviewers = data.get(0).get("Reviewers");
            per.addTrackerWithInvalidData1(trackerName, employeeName, reviewers);
            performancePages.saveButton.click();
        }
        LogManagers.logInfo("Invalid Trackers details have been Given and Asserted");
    }

    // Step to verify error message for invalid input
    @Then("The system should display an error message indicating {string}")
    public void the_system_should_display_an_error_message_indicating_employee_name(String string) {
        per.VerifyErrorMessage(string);
        LogManagers.logInfo("Error Message Displayed");
    }
}

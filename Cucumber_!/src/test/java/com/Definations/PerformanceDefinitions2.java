package com.Definations;

import com.Actions.PerformanceActions2;
import com.Actions.LoginActions;
import com.Pages.PerformancePages2;
import com.Utils.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class PerformanceDefinitions2 {

    WebDriver driver;
    LoginActions login;
    PerformancePages2 pages;
    PerformanceActions2 actions;
    PerformanceActions2 performanceActions = new PerformanceActions2();

    public PerformanceDefinitions2() {
        driver = HelperClass.getDriver();
        login = new LoginActions();
        pages = new PerformancePages2();
        actions = new PerformanceActions2();
    }

    @When("the user clicks Manage Reviews and selects My Reviews")
    public void the_user_clicks_manage_reviews_and_selects_my_reviews() {
        actions.clickManageReviewsAndSelectMyReviews();
    }

    @Then("verify the following credentials")
    public void verify_the_following_credentials(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        actions.verifyCredentials(data);
    }
    
    
    
    
    
    
    
    
    
    
    
    @When("the user clicks My Trackers")
    public void the_user_clicks_my_trackers() {
        actions.clickMyTrackers();
    }

    @Then("verify the Tracker Name in MyPerformance Trackers")
    public void verify_the_tracker_name_in_my_performance_trackers() {
        actions.verifyMyTrackerName("Tracker for paul"); 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    @When("the user clicks Employee Trackers")
    public void the_user_clicks_employee_trackers() {
        actions.clickEmployeeTrackers();
    }

    @When("Enter the Employee Name and Include")
    public void enter_the_employee_name_and_include() {
        actions.enterEmployeeNameAndInclude("Gayu R"); 
    }

    @When("Click Search")
    public void click_search() {
        actions.clickSearchInEmployeeTrackers();
    }

    @Then("verify the Employee Name is searched in Employee Trackers")
    public void verify_the_employee_name_is_searched_in_employee_trackers() {
        actions.verifySearchedEmployee("Gayu R"); 
    }
    
    
    
    
    
    
    
    
    @When("Enter the invalid Employee Name and Include")
    public void enter_the_invalid_employee_name_and_include() {
        actions.enterEmployeeNameAndInclude("Invalid Name");
    }

//    @Then("verify the Employee Name is not found in Employee Trackers")
//    public void verify_the_employee_name_is_not_found_in_employee_trackers() {
//        actions.verifySearchedEmployeeNotFound();
  //  }
    
    @Then("verify the message {string} is shown in Employee Trackers")
    public void verify_the_message_is_shown_in_employee_trackers(String expectedMessage) {
        performanceActions.verifySearchedEmployeeMessage(expectedMessage);
    }



}

//package com.Definations;
//
//import com.Actions.PerformanceActions2;
//import com.Actions.LoginActions;
//import com.Pages.PerformancePages2;
//import com.Utils.HelperClass;
//import com.Utils.LogManagers;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.*;
//
//import java.util.List;
//import java.util.Map;
//
//import org.openqa.selenium.WebDriver;
//
//public class PerformanceDefinitions2 {
//
//    WebDriver driver;
//    LoginActions login;
//    PerformancePages2 pages;
//    PerformanceActions2 actions;
//    PerformanceActions2 performanceActions = new PerformanceActions2();
//
//    public PerformanceDefinitions2() {
//        driver = HelperClass.getDriver();
//        login = new LoginActions();
//        pages = new PerformancePages2();
//        actions = new PerformanceActions2();
//    }
//
//    @When("the user clicks Manage Reviews and selects My Reviews")
//    public void the_user_clicks_manage_reviews_and_selects_my_reviews() {
//        try {
//            actions.clickManageReviewsAndSelectMyReviews();
//            LogManagers.logInfo("Clicked on Managed Review");
//            LogManagers.logInfo("Selected My Reviews");
//        } catch (Exception e) {
//            LogManagers.logError("Error in clicking Manage Reviews and selecting My Reviews: " + e.getMessage());
  //          throw e;
//        }
//    }
//
//    @Then("verify the following credentials")
//    public void verify_the_following_credentials(DataTable dataTable) {
//        try {
//            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//            actions.verifyCredentials(data);
//            LogManagers.logInfo("Verified");
//        } catch (Exception e) {
//            LogManagers.logError("Error verifying credentials: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    @When("the user clicks My Trackers")
//    public void the_user_clicks_my_trackers() {
//        try {
//            actions.clickMyTrackers();
//        } catch (Exception e) {
//            LogManagers.logError("Error clicking My Trackers: " + e.getMessage());
            //    throw e;
//        }
//    }
//
//    @Then("verify the Tracker Name in MyPerformance Trackers")
//    public void verify_the_tracker_name_in_my_performance_trackers() {
//        try {
//            actions.verifyMyTrackerName("Tracker for paul");
//        } catch (Exception e) {
//            LogManagers.logError("Error verifying Tracker Name in MyPerformance Trackers: " + e.getMessage());
           //   throw e;
//        }

//    }
//
//    @When("the user clicks Employee Trackers")
//    public void the_user_clicks_employee_trackers() {
//        try {
//            actions.clickEmployeeTrackers();
//        } catch (Exception e) {
//            LogManagers.logError("Error clicking Employee Trackers: " + e.getMessage());
          //    throw e;
//        }
//    }
//
//    @When("Enter the Employee Name and Include")
//    public void enter_the_employee_name_and_include() {
//        try {
//            actions.enterEmployeeNameAndInclude("Gayu R");
//        } catch (Exception e) {
//            LogManagers.logError("Error entering Employee Name and Include: " + e.getMessage());
        //    throw e;
//        }
//    }
//
//    @When("Click Search")
//    public void click_search() {
//        try {
//            actions.clickSearchInEmployeeTrackers();
//        } catch (Exception e) {
//            LogManagers.logError("Error clicking Search in Employee Trackers: " + e.getMessage());
       //    throw e;
//        }
//    }
//
//    @Then("verify the Employee Name is searched in Employee Trackers")
//    public void verify_the_employee_name_is_searched_in_employee_trackers() {
//        try {
//            actions.verifySearchedEmployee("Gayu R");
//        } catch (Exception e) {
//            LogManagers.logError("Error verifying searched Employee Name: " + e.getMessage());
//        }
//    }
//
//    @When("Enter the invalid Employee Name and Include")
//    public void enter_the_invalid_employee_name_and_include() {
//        try {
//            actions.enterEmployeeNameAndInclude("Invalid Name");
//        } catch (Exception e) {
//            LogManagers.logError("Error entering invalid Employee Name: " + e.getMessage());
   //    throw e;
//        }
//    }
//
//    @Then("verify the message {string} is shown in Employee Trackers")
//    public void verify_the_message_is_shown_in_employee_trackers(String expectedMessage) {
//        try {
//            performanceActions.verifySearchedEmployeeMessage(expectedMessage);
//        } catch (Exception e) {
//            LogManagers.logError("Error verifying message in Employee Trackers: " + e.getMessage());
//            throw e;
//        }
//    }
//}



package com.Definations;

import com.Actions.PerformanceActions2;
import com.Actions.LoginActions;
import com.Pages.PerformancePages2;
import com.Utils.HelperClass;
import com.Utils.LogManagers;

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
        LogManagers.logInfo("Clicked on Managed Review");
        LogManagers.logInfo("Selected My Reviews");
    }

    @Then("verify the following credentials")
    public void verify_the_following_credentials(DataTable dataTable) {
        try {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            actions.verifyCredentials(data);
            LogManagers.logInfo("Verified");
        } catch (Exception e) {
            LogManagers.logError("Error verifying credentials: " + e.getMessage());
            throw e;
        }
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
        try {
            actions.verifySearchedEmployee("Gayu R");
        } catch (Exception e) {
            LogManagers.logError("Error verifying searched Employee Name: " + e.getMessage());
        }
    }

    @When("Enter the invalid Employee Name and Include")
    public void enter_the_invalid_employee_name_and_include() {
        actions.enterEmployeeNameAndInclude("Invalid Name");
    }

    @Then("verify the message {string} is shown in Employee Trackers")
    public void verify_the_message_is_shown_in_employee_trackers(String expectedMessage) {
        try {
            performanceActions.verifySearchedEmployeeMessage(expectedMessage);
        } catch (Exception e) {
            LogManagers.logError("Error verifying message in Employee Trackers: " + e.getMessage());
            throw e;
        }
    }
}

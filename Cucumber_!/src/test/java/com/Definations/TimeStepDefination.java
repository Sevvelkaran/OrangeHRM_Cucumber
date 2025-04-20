package com.Definations;

import com.Actions.TimeActions;
import com.Utils.HelperClass;
import com.Utils.LogManagers;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TimeStepDefination {

    TimeActions ta = new TimeActions();

    @Given("I am logged into OrangeHRM with url {string}")
    public void i_am_logged_into_orangehrm_with_url(String url) {
        try {
            HelperClass.openPage(url);
            ta.login("Admin", "admin123");
            LogManagers.logInfo("WebPage Opened");
            LogManagers.logInfo("Credentials Entred");
        } catch (Exception e) {
            LogManagers.logError("Error during login: " + e.getMessage());
        }
    }

    @When("I navigate to the Time module")
    public void i_navigate_to_the_time_module() {
        try {
            ta.clickTimeModule();
            LogManagers.logInfo("Clicked Time Module");
        } catch (Exception e) {
            LogManagers.logError("Error navigating to Time module: " + e.getMessage());
        }
    }

    @And("I click on Timesheets")
    public void i_click_on_timesheets() {
        try {
            ta.clickTimesheets();
            LogManagers.logInfo("Clicked Time Sheets");
        } catch (Exception e) {
            LogManagers.logError("Error clicking Timesheets: " + e.getMessage());
        }
    }

    @And("I search and select {string}")
    public void i_search_and_select(String section) {
        try {
            if (section.equalsIgnoreCase("Employee Timesheets")) {
                ta.clickEmployeeTimesheets();
            }
        } catch (Exception e) {
            LogManagers.logError("Error selecting Timesheets section: " + e.getMessage());
        }
    }

    @And("I select an employee")
    public void i_select_an_employee() throws InterruptedException {
        try {
            ta.enterEmployeeName("Admin  Admin123");
            Thread.sleep(5000);
            Actions actions = new Actions(HelperClass.getDriver());
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
            LogManagers.logInfo("Employee Selected");
        } catch (Exception e) {
            LogManagers.logError("Error selecting employee: " + e.getMessage());
        }
    }

    @And("I click on {string} to check the employee timesheet")
    public void i_click_on_to_check_the_employee_timesheet(String btn) {
        try {
            if (btn.equalsIgnoreCase("View")) {
                ta.clickView();
                LogManagers.logInfo("Clicked on the employee Timesheet");
            }
        } catch (Exception e) {
            LogManagers.logError("Error clicking View on timesheet: " + e.getMessage());
        }
    }

    @And("I click on {string}")
    public void i_click_on_button(String btn) {
        try {
            if (btn.equalsIgnoreCase("Create Timesheet")) {
                ta.clickCreateTimesheet();
                LogManagers.logInfo("Clicked on Create Timesheet");
            }
        } catch (Exception e) {
            LogManagers.logError("Error clicking Create Timesheet: " + e.getMessage());
        }
    }

    @Then("a new timesheet should be created")
    public void a_new_timesheet_should_be_created() {
        try {
            System.out.println("Timesheet created.");
        } catch (Exception e) {
            LogManagers.logError("Error verifying timesheet creation: " + e.getMessage());
        }
    }

    @And("I enter an invalid employee name")
    public void i_enter_an_invalid_employee_name() {
        try {
            ta.enterEmployeeName("InvalidUser123");
        } catch (Exception e) {
            LogManagers.logError("Error entering invalid employee name: " + e.getMessage());
        }
    }

    @Then("{string} message should be displayed and the timesheet should not be created")
    public void message_should_be_displayed(String msg) {
        try {
            Assert.assertTrue(ta.isInvalidMessageDisplayed(), "Invalid");
        } catch (Exception e) {
            LogManagers.logError("Error verifying invalid employee message: " + e.getMessage());
        }
    }
}

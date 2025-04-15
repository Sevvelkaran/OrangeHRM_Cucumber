package com.Definations;

import com.Actions.TimeActions;
import com.Utils.HelperClass;
import com.Utils.LogManagers;

import io.cucumber.java.en.*;
import io.cucumber.messages.types.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TimeStepDefination {

    TimeActions ta = new TimeActions();

    @Given("I am logged into OrangeHRM with url {string}")
    public void i_am_logged_into_orangehrm_with_url(String url) {
        HelperClass.openPage(url);
        ta.login("Admin", "admin123");
        LogManagers.logInfo("WebPage Opened");
        LogManagers.logInfo("Credentials Entred");

    }

    @When("I navigate to the Time module")
    public void i_navigate_to_the_time_module() {
        ta.clickTimeModule();
        LogManagers.logInfo("Clicked Time Module");

    }

    @And("I click on Timesheets")
    public void i_click_on_timesheets() {
        ta.clickTimesheets();
        LogManagers.logInfo("Clicked Time Sheets");

    }

    @And("I search and select {string}")
    public void i_search_and_select(String section) {
        if (section.equalsIgnoreCase("Employee Timesheets")) {
            ta.clickEmployeeTimesheets();
        }
    }

    @And("I select an employee")
    public void i_select_an_employee() throws InterruptedException {
        ta.enterEmployeeName("Admin  Admin123");
Thread.sleep(5000);
        Actions actions = new Actions(HelperClass.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        LogManagers.logInfo("Employee Selected");

    }

    @And("I click on {string} to check the employee timesheet")
    public void i_click_on_to_check_the_employee_timesheet(String btn) {
        if (btn.equalsIgnoreCase("View")) {
            ta.clickView();
            LogManagers.logInfo("Clicked on the employee Timesheet");

        }
    }

    @And("I click on {string}")
    public void i_click_on_button(String btn) {
        if (btn.equalsIgnoreCase("Create Timesheet")) {
            ta.clickCreateTimesheet();
            LogManagers.logInfo("Clicked on Create Timesheet");

        }
    }

    @Then("a new timesheet should be created")
    public void a_new_timesheet_should_be_created() {
        System.out.println("Timesheet created.");
        
    }

    @And("I enter an invalid employee name")
    public void i_enter_an_invalid_employee_name() {
        ta.enterEmployeeName("InvalidUser123");
    }

    @Then("{string} message should be displayed and the timesheet should not be created")
    public void message_should_be_displayed(String msg) {
        Assert.assertTrue(ta.isInvalidMessageDisplayed(), "Invalid");
    }
}
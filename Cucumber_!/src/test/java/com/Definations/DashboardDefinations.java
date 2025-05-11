package com.Definations;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Actions.DashboardActions;
import com.Actions.LoginActions;
import com.Pages.LoginPages;
import com.Utils.HelperClass;
import com.Utils.LogManagers;

import io.cucumber.java.en.*;

public class DashboardDefinations {

    WebDriver driver = HelperClass.getDriver();
    LoginPages objlog = new LoginPages();
    LoginActions objLogin = new LoginActions();
    DashboardActions objAct = new DashboardActions();

    @Given("I want to go into OrangeHRM {string}")
    public void i_want_to_go_into_orange_hrm(String url) {
        try {
            HelperClass.openPage(url);
            objLogin = new LoginActions();
            LogManagers.logInfo("WebPage Opened");
        } catch (Exception e) {
            LogManagers.logError("Error while opening OrangeHRM URL: " + e.getMessage());
        }
    }

    @When("The user enters the username {string} and password {string} to login")
    public void the_user_enters_the_username_and_password_to_login(String username, String password) {
        try {
            objLogin.enterUsernameAndPassword(username, password);  // Passing dynamic username and password
            objLogin.Login();
            LogManagers.logInfo("Credentials Entered for username: " + username);
        } catch (Exception e) {
            LogManagers.logError("Error while entering credentials: " + e.getMessage());
        }
    }

    @When("The user is on the dashboard and clicks on the clock icon in the Time at Work section")
    public void the_user_is_on_the_dashboard_and_clicks_on_the_clock_icon_in_the_time_at_work_section() {
        try {
            objAct.clock();
            LogManagers.logInfo("Clicked on Clock");
        } catch (Exception e) {
            LogManagers.logError("Error while clicking clock icon: " + e.getMessage());
        }
    }

    @When("The user enters the out time and punches out")
    public void the_user_enters_the_out_time_and_punches_out() {
        try {
            objAct.time();
            objAct.arrow();
            LogManagers.logInfo("Time Entered");
            objAct.out();
            LogManagers.logInfo("Out Clicked");
            objAct.DashBoard();
            LogManagers.logInfo("In Dashboard Page");
        } catch (Exception e) {
            LogManagers.logError("Error during punch out flow: " + e.getMessage());
        }
    }

    @Then("Assert that the user is on the Dashboard page")
    public void assert_that_the_user_is_on_the_dashboard_page() {
        try {
            String expected = "OrangeHRM";
            String actual = driver.getTitle();
            assertEquals(actual, expected);
        } catch (Exception e) {
            LogManagers.logError("Error asserting dashboard page: " + e.getMessage());
        }
    }

    @When("The user is on the dashboard and asserts the name Dashboard {string}")
    public void the_user_is_on_the_dashboard_and_asserts_the_name_dashboard(String expectedDashboardName) {
        try {
            WebElement dash = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
            String actualDashboardName = dash.getText();
            assertEquals(actualDashboardName, expectedDashboardName, "Dashboard name mismatch!");
            LogManagers.logInfo("Dashboard name asserted: " + actualDashboardName);
        } catch (Exception e) {
            LogManagers.logError("Error asserting dashboard name: " + e.getMessage());
        }
    }

    @Then("The user asserts all the quick action {string}")
    public void the_user_asserts_all_the_quick_action(String quickAction) {
        try {
            String act = "";
            String exp = quickAction;

            switch (quickAction) {
                case "Assign Leave":
                    act = driver.findElement(By.xpath("//p[text()='Assign Leave']")).getText();
                    LogManagers.logInfo("Assign Leave Asserted");
                    break;
                case "Leave List":
                    act = driver.findElement(By.xpath("//p[text()='Leave List']")).getText();
                    LogManagers.logInfo("Leave List Asserted");
                    break;
                case "Timesheets":
                    act = driver.findElement(By.xpath("//p[text()='Timesheets']")).getText();
                    LogManagers.logInfo("Timesheets Asserted");
                    break;
                case "Apply Leave":
                    act = driver.findElement(By.xpath("//p[text()='Apply Leave']")).getText();
                    LogManagers.logInfo("Apply Leave Asserted");
                    break;
                case "My Leave":
                    act = driver.findElement(By.xpath("//p[text()='My Leave']")).getText();
                    LogManagers.logInfo("My Leave Asserted");
                    break;
                case "My Timesheet":
                    act = driver.findElement(By.xpath("//p[text()='My Timesheet']")).getText();
                    LogManagers.logInfo("My Timesheet Asserted");
                    break;
                default:
                    LogManagers.logError("Quick Action not recognized: " + quickAction);
                    return;
            }

            assertEquals(act, exp, "Quick Action mismatch: " + quickAction);

        } catch (Exception e) {
            LogManagers.logError("Error asserting quick action '" + quickAction + "': " + e.getMessage());
        }
    }
}

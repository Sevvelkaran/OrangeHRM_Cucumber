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

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class DashboardDefinations {

    WebDriver driver = HelperClass.getDriver();

    LoginPages objlog = new LoginPages();
    LoginActions objLogin = new LoginActions();
    DashboardActions objAct = new DashboardActions();

    // Step to open the OrangeHRM URL
    @Given("I want to go into OrangeHRM {string}")
    public void i_want_to_go_into_orange_hrm(String url) {
        HelperClass.openPage(url);
        objLogin = new LoginActions();
        LogManagers.logInfo("WebPage Opend");
    }

    // Step to login using valid credentials
    @When("The user enters the username and password to login")
    public void the_user_enters_the_username_and_password_to_login() {
        objLogin.Valid();
        objLogin.Login();
        LogManagers.logInfo("Credentials Entered");
    }

    // Step to click on the clock icon under Time at Work section
    @When("The user is on the dashboard and clicks on the clock icon in the Time at Work section")
    public void the_user_is_on_the_dashboard_and_clicks_on_the_clock_icon_in_the_time_at_work_section() {
        objAct.clock();
        LogManagers.logInfo("Clicked on Clock");
    }

    // Step to enter out time, punch out, and return to dashboard
    @When("The user enters the out time and punches out")
    public void the_user_enters_the_out_time_and_punches_out() {
        objAct.time();
        objAct.arrow();
        LogManagers.logInfo("Time Entered");
        objAct.out();
        LogManagers.logInfo("Out Clicked");
        objAct.DashBoard();    
        LogManagers.logInfo("In Dashboard Page");
    }

    // Assertion to verify the user is on Dashboard page using page title
    @Then("Assert that the user is on the Dashboard page")
    public void assert_that_the_user_is_on_the_dashboard_page() {
        WebDriver driver = HelperClass.getDriver();
        String Expected = "OrangeHRM";
        String Orginal = driver.getTitle();
        assertEquals(Orginal, Expected);
    }

    // Assertion to verify the "Dashboard" text is displayed on the page
    @When("Assert the name Dashboard {string}")
    public void assert_the_name_dashboard(String dashboard) {
        WebElement dash = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        assertEquals(dash.getText(), dashboard);
    }

    // Assertion to verify each quick action card on the dashboard
    @Then("the user asserts all the quick Action {string}")
    public void the_user_asserts_all_the_quick_action(String quickAction) {
        String act = "";
        String exp = quickAction;

        switch (quickAction) {
            case "Assign Leave":
                act = driver.findElement(By.xpath("//p[text()='Assign Leave']")).getText();
                LogManagers.logInfo("Align Leave Asserted");
                break;
            case "Leave List":
                act = driver.findElement(By.xpath("//p[text()='Leave List']")).getText();
                LogManagers.logInfo("Leave list Asserted");
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
        }

        assertEquals(act, exp);
    }
}

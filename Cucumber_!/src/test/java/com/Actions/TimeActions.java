package com.Actions;

import org.openqa.selenium.support.PageFactory;
import com.Pages.TimePage;
import com.Utils.HelperClass;

public class TimeActions {
    TimePage tp;

    public TimeActions() {
        tp = new TimePage();
        PageFactory.initElements(HelperClass.getDriver(), tp);
    }

    public void login(String user, String pass) {
        try {
            tp.username.sendKeys(user);
            tp.password.sendKeys(pass);
            tp.loginBtn.click();
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }

    public void clickTimeModule() {
        try {
            tp.timeModule.click();
        } catch (Exception e) {
            System.out.println("Failed to click Time Module: " + e.getMessage());
        }
    }

    public void clickTimesheets() {
        try {
            tp.timesheets.click();
        } catch (Exception e) {
            System.out.println("Failed to click Timesheets: " + e.getMessage());
        }
    }

    public void clickEmployeeTimesheets() {
        try {
            tp.employeeTimesheets.click();
        } catch (Exception e) {
            System.out.println("Failed to click Employee Timesheets: " + e.getMessage());
        }
    }

    public void enterEmployeeName(String name) {
        try {
            tp.employeeNameInput.clear();
            tp.employeeNameInput.sendKeys(name);
        } catch (Exception e) {
            System.out.println("Failed to enter employee name: " + e.getMessage());
        }
    }

    public void clickView() {
        try {
            tp.viewButton.click();
        } catch (Exception e) {
            System.out.println("Failed to click View button: " + e.getMessage());
        }
    }

    public void clickCreateTimesheet() {
        try {
            tp.createTimesheetButton.click();
        } catch (Exception e) {
            System.out.println("Failed to click Create Timesheet: " + e.getMessage());
        }
    }

    public boolean isInvalidMessageDisplayed() {
        try {
            return tp.invalidMessage.isDisplayed();
        } catch (Exception e) {
            System.out.println("Error checking invalid message: " + e.getMessage());
            return false;
        }
    }
}

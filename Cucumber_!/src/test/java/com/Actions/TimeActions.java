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
        tp.username.sendKeys(user);
        tp.password.sendKeys(pass);
        tp.loginBtn.click();
    }

    public void clickTimeModule() {
        tp.timeModule.click();
    }

    public void clickTimesheets() {
        tp.timesheets.click();
    }

    public void clickEmployeeTimesheets() {
        tp.employeeTimesheets.click();
    }

    public void enterEmployeeName(String name) {
        tp.employeeNameInput.sendKeys(name);
    }

    public void clickView() {
        tp.viewButton.click();
    }

    public void clickCreateTimesheet() {
        tp.createTimesheetButton.click();
    }

    public boolean isInvalidMessageDisplayed() {
        return tp.invalidMessage.isDisplayed();
    }
}
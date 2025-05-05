package com.Definations;

import com.Actions.LeaveActions;
import com.Utils.LogManagers;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class LeaveStepDefinition {

    LeaveActions la = new LeaveActions();

    @When("the user navigates to the Leave module")
    public void goToLeaveModule() {
        la.navigateToLeaveModule();
        LogManagers.logInfo("Navigated to Leave module");
    }

    @When("the user clicks on Assign Leave")
    public void clickAssignLeave() {
        la.openAssignLeave();
        LogManagers.logInfo("Opened Assign Leave");
    }

//    @When("the user enters leave details:")
//    public void enterLeaveDetails(DataTable dataTable) {
//        Map<String, String> data = dataTable.asMap(String.class, String.class);
//        la.fillLeaveDetails(data.get("EmployeeName"), data.get("LeaveType"), data.get("FromDate"), data.get("ToDate"));
//        LogManagers.logInfo("Entered leave details");
//    }
    @When("the user enters leave details:")
    public void the_user_enters_leave_details(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            la.fillLeaveDetails(row.get("EmployeeName"), row.get("LeaveType"), row.get("FromDate"), row.get("ToDate"));
            LogManagers.logInfo("Entered leave details for: " + row.get("EmployeeName"));
        }
    }
    @When("the user clicks the Assign button")
    public void assignLeave() {
        la.clickAssign();
        LogManagers.logInfo("Clicked Assign");
    }

    @Then("the leave should be assigned successfully")
    public void verifyAssignment() {
        System.out.println("Leave assigned successfully!");
    }
}

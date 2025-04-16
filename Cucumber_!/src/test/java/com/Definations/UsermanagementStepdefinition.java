package com.Definations;

import com.Actions.UsermanagementAction;
import com.Utils.LogManagers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsermanagementStepdefinition {

    // Creating instance of the action class to access UI operations
    UsermanagementAction user = new UsermanagementAction();

    // Step: Click on Admin menu
    @When("the user click the Admin menu")
    public void the_user_click_the_admin_menu() {
        user.clickAdmin();
        LogManagers.logInfo("Clicked Admin Menu");
    }

    // Step: Click User Management > Users
    @When("the user click on User Management and select Users")
    public void the_user_click_on_user_management_and_select_users() throws InterruptedException {
        user.clickUsers();
        LogManagers.logInfo("Clicked UserManagement");
        LogManagers.logInfo("Clicked Selected users");
    }

    // Step: Click Add button
    @When("the user click the Add button")
    public void the_user_click_the_add_button() {
        user.clickAdd();
        LogManagers.logInfo("Clicked Add Button");
    }

    // Step: Fill user details from data table
    @When("the user fills in the user details:")
    public void the_user_fills_in_the_user_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        user.Senddata(dataTable);
        LogManagers.logInfo("User Details Filled");
    }

    // Step: Click Save button
    @When("clicks the Save button")
    public void clicks_the_save_button() {
        user.saveform();
        LogManagers.logInfo("Clicked the save button");
    }

    // Step: Verify user added (implementation pending)
    @Then("the user should be added to the records")
    public void the_user_should_be_added_to_the_records() {
        // To be implemented: verify user was added
    }

    // Step: Fill filter fields for user search
    @When("the user fills in the filter fields with {string},{string},{string},{string}")
    public void the_user_fills_in_the_filter_fields_with(String string, String string2, String string3, String string4) throws InterruptedException {
        user.searchdatas(string, string2, string3, string4);
        LogManagers.logInfo("Filled the Filter Fileds");
    }

    // Step: Click Search button
    @When("click the search button")
    public void click_the_search_button() throws InterruptedException {
        Thread.sleep(3000); // Wait for fields to populate before search
        user.clicksearch();
        LogManagers.logInfo("Clicked the Search button");
    }

    // Step: Verify user is listed (implementation pending)
    @Then("the user should be able to see the specific user in the list")
    public void the_user_should_be_able_to_see_the_specific_user_in_the_list() {
        // To be implemented: verify searched user is visible
    }

    // Step: Verify error message
    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String string) {
        user.errorverify(string);
        LogManagers.logInfo("Error Message Displayed");
    }

    // Step: Select user for deletion
    @When("the user selects the user to be deleted")
    public void the_user_selects_the_user_to_be_deleted() {
        user.select();
        LogManagers.logInfo("Selects the User to be Deleted");
    }

    // Step: Click Delete button
    @When("the user clicks the Delete button")
    public void the_user_clicks_the_delete_button() {
        user.Deleteclick();
        LogManagers.logInfo("Clicked Delete Button");
    }

    // Step: Confirm deletion
    @When("the user confirms the deletion")
    public void the_user_confirms_the_deletion() {
        user.ConformDelete();
        LogManagers.logInfo("Confirmed Delete");
    }

    // Step: Verify user deleted (implementation pending)
    @Then("the user account should be successfully deleted")
    public void the_user_account_should_be_successfully_deleted() {
        // To be implemented: verify user is deleted from the list
    }
}

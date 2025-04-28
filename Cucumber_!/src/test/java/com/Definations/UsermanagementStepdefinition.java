package com.Definations;

import com.Actions.UsermanagementAction;
import com.Utils.LogManagers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsermanagementStepdefinition {
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

   
    // Step: Fill filter fields for user search
    @When("the user fills in the filter fields with {string},{string},{string},{string}")
    public void the_user_fills_in_the_filter_fields_with(String string, String string2, String string3, String string4) throws InterruptedException {
        user.searchdatas(string, string2, string3, string4);
        LogManagers.logInfo("Filled the Filter Fileds");
    }

    // Step: Click Search button
    @When("click the search button")
    public void click_the_search_button() throws InterruptedException {
        user.clicksearch();
        LogManagers.logInfo("Clicked the Search button");
    }


    // Step: Verify error message
    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String string) {
        user.errorverify(string);
        LogManagers.logInfo("Error Message Displayed");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Step: Verify user added (implementation pending)
    @Then("the user should be added to the records")
    public void the_user_should_be_added_to_the_records() {
    }

    // Step: Verify user is listed (implementation pending)
    @Then("the user should be able to see the specific user in the list")
    public void the_user_should_be_able_to_see_the_specific_user_in_the_list() {
    }
}
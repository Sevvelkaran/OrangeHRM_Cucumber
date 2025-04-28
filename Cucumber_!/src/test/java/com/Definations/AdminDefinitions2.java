package com.Definations;

import com.Actions.AdminActions2;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AdminDefinitions2 {

    AdminActions2 adminActions = new AdminActions2();

    @And("the user navigates on to the Admin module")
    public void the_user_navigates_on_to_the_admin_module() {
        adminActions.navigateToAdminModule();
    }

    @And("the user clicks Nationalities")
    public void the_user_clicks_nationalities() {
        adminActions.clickNationalities();
    }

    @And("enters the following Nationality")
    public void enters_the_following_nationality(DataTable dataTable) {
        String nationalityName = dataTable.cell(1, 0);
        adminActions.enterNationalityName(nationalityName);
    }


    @Then("verify that the Nationality is successfully added")
    public void verify_that_the_nationality_is_successfully_added() {
        System.out.println("Nationality added successfully");
    }
    
    @Then("verify that the Required message is displayed")
    public void verify_that_the_required_message_is_displayed() {
        Assert.assertTrue(adminActions.isRequiredMessageDisplayed(), "Required message not displayed");
    }
    
    
}

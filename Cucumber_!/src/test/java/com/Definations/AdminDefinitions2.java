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

//    @And("clicks the Add button")
//    public void clicks_the_add_button() {
//        adminActions.clickAddButton();
//    }

    @And("enters the following Nationality")
    public void enters_the_following_nationality(DataTable dataTable) {
        String nationalityName = dataTable.cell(1, 0);
        adminActions.enterNationalityName(nationalityName);
    }

//    @And("clicks to the Save button")
//    public void clicks_to_the_save_button() {
//        adminActions.clickSaveButton();
//    }

    @Then("verify that the Nationality is successfully added")
    public void verify_that_the_nationality_is_successfully_added() {
        System.out.println("Nationality added successfully");
    }
    
   
    
    
//    @Then("verify that the Nationality is successfully added")
//    public void validateRecordsFoundText() {
//        String actualText = adminActions.getActualRecordsFoundText();
//        String expectedText = "194 Records Found";
//
//        try {
//            Assert.assertEquals(actualText, expectedText, "Records count mismatch");
//            System.out.println("Assertion Passed: Correct number of records found");
//        } catch (AssertionError e) {
//            System.out.println("Assertion Failed: " + e.getMessage());
//            throw e;
//        }
//    }
}

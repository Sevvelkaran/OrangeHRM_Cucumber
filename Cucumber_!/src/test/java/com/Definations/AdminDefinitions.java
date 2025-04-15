package com.Definations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;

import com.Actions.AdminActions;
import com.Actions.LoginActions;
import com.Utils.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AdminDefinitions {

    private WebDriver driver;
    private LoginActions login;
    private AdminActions admin;
    private String level;  
    private String membershipName; 

    public AdminDefinitions() {
        driver = HelperClass.getDriver();
        login = new LoginActions();
        admin = new AdminActions();
    }
    
    @Given("The user launches the browser and login")
    public void the_user_launches_the_browser_and_navigates_to_the_performance_module() {
       
        login.Valid();
        login.Login();
    }
    
    @When("the user navigates to the Admin module")
    public void the_user_navigates_to_the_admin_module() {
    	admin.goToAdminModule();
    }

    @When("the user clicks on Qualifications and selects Education")
    public void the_user_clicks_on_qualifications_and_selects_education() {
        admin.goToEducationSection();
    }

    @When("clicks the Add button")
    public void clicks_the_add_button() {
        admin.clickAddButton();
    }

    @When("enters the following Education Details")
    public void enters_the_following_education_details(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        level = rows.get(0).get("Level");
        admin.enterEducationLevel(level);
    }

    @When("clicks to the Save button")
    public void clicks_to_the_save_button() {
        admin.clickSaveButton();
    }

    @Then("verify that the Education Details are successfully added")
    public void verify_that_the_education_details_are_successfully_added() {
        Assert.assertTrue(
            admin.isEducationDisplayed(level),"Education level is invalid"
        );
    }
    @Then("verify that an error message {string} is displayed")
    public void verify_that_an_error_message_is_displayed(String errorMessage) {
        Assert.assertTrue(admin.isDuplicateErrorDisplayed(errorMessage), 
            "Expected error message '" + errorMessage + "' was not displayed");
    }
    @When("the user clicks the Qualificatins and selects Memberships")
    public void the_user_clicks_the_qualificatins_and_selects_memberships() {
        admin.goToMembershipsSection();
    }

    @When("enters the following Membership Details")
    public void enters_the_following_membership_details(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        membershipName = rows.get(0).get("Name");
        admin.enterMembershipName(membershipName);
    }

    @Then("verify that the Memberships Details are successfully added")
    public void verify_that_the_memberships_details_are_successfully_added() {
        Assert.assertTrue(admin.isMembershipDisplayed(membershipName), "Membership name is not displayed!");
    }
     
    
    @Then("verify the error message {string} is displayed")
    public void verify_the_error_message_is_displayed(String expectedError) {
        WebElement errorElement = driver.findElement(By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]"));
        String actualError = errorElement.getText();
        Assert.assertEquals(actualError, expectedError);
    }

}
    


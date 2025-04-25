package com.Definations;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
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
    
    // Create Logger instance
    private static final Logger logger = LogManager.getLogger(AdminDefinitions.class);

    public AdminDefinitions() {
        driver = HelperClass.getDriver();
        login = new LoginActions();
        admin = new AdminActions();
    }

    @Given("The user launches the browser and login")
    public void the_user_launches_the_browser_and_navigates_to_the_performance_module() {
        try {
            login.Valid();
            login.Login();
        } catch (Exception e) {
            logger.error("Error occurred during login: " + e.getMessage(), e);
            throw e; 
        }
    }

    @When("the user navigates to the Admin module")
    public void the_user_navigates_to_the_admin_module() {
        try {
            admin.goToAdminModule();
        } catch (Exception e) {
            logger.error("Error navigating to Admin module: " + e.getMessage(), e);
            throw e; 
        }
    }

    @When("the user clicks on Qualifications and selects Education")
    public void the_user_clicks_on_qualifications_and_selects_education() {
        try {
            admin.goToEducationSection();
        } catch (Exception e) {
            logger.error("Error navigating to Education section: " + e.getMessage(), e);
            throw e;
        }
    }

    @When("clicks the Add button")
    public void clicks_the_add_button() {
        try {
            admin.clickAddButton();
        } catch (Exception e) {
            logger.error("Error clicking the Add button: " + e.getMessage(), e);
            throw e;
        }
    }

    @When("enters the following Education Details")
    public void enters_the_following_education_details(DataTable dataTable) {
        try {
            List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
            level = rows.get(0).get("Level");
            admin.enterEducationLevel(level);
        } catch (Exception e) {
            logger.error("Error entering Education Details: " + e.getMessage(), e);
            throw e;
        }
    }

    @When("clicks to the Save button")
    public void clicks_to_the_save_button() {
        try {
            admin.clickSaveButton();
        } catch (Exception e) {
            logger.error("Error clicking the Save button: " + e.getMessage(), e);
            throw e;
        }
    }

    @Then("verify that the Education Details are successfully added")
    public void verify_that_the_education_details_are_successfully_added() {
        try {
            Assert.assertTrue(admin.isEducationDisplayed(level), "Education level is invalid");
        } catch (AssertionError e) {
            logger.error("Education level validation failed: " + e.getMessage(), e);
            throw e; // rethrow to fail the test
        }
    }

    @Then("verify that an error message {string} is displayed")
    public void verify_that_an_error_message_is_displayed(String errorMessage) {
        try {
            Assert.assertTrue(admin.isDuplicateErrorDisplayed(errorMessage), 
                "Expected error message '" + errorMessage + "' was not displayed");
        } catch (AssertionError e) {
            logger.error("Error message validation failed: " + e.getMessage(), e);
            throw e;
        }
    }

    @When("the user clicks the Qualifications and selects Memberships")
    public void the_user_clicks_the_qualificatins_and_selects_memberships() {
        try {
            admin.goToMembershipsSection();
        } catch (Exception e) {
            logger.error("Error navigating to Memberships section: " + e.getMessage(), e);
            throw e;
        }
    }

    @When("enters the following Membership Details")
    public void enters_the_following_membership_details(DataTable dataTable) {
        try {
            List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
            membershipName = rows.get(0).get("Name");
            admin.enterMembershipName(membershipName);
        } catch (Exception e) {
            logger.error("Error entering Membership Details: " + e.getMessage(), e);
            throw e;
        }
    }

    @Then("verify that the Memberships Details are successfully added")
    public void verify_that_the_memberships_details_are_successfully_added() {
        try {
            Assert.assertTrue(admin.isMembershipDisplayed(membershipName), "Membership name is not displayed!");
        } catch (AssertionError e) {
            logger.error("Membership name validation failed: " + e.getMessage(), e);
            throw e;
        }
    }

    @Then("verify the error message {string} is displayed")
    public void verify_the_error_message_is_displayed(String expectedError) {
        try {
            WebElement errorElement = driver.findElement(By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]"));
            String actualError = errorElement.getText();
            Assert.assertEquals(actualError, expectedError);
        } catch (Exception e) {
            logger.error("Error validating the error message: " + e.getMessage(), e);
            throw e;
        }
    }
}

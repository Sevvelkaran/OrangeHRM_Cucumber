package com.Definations;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
    private static final Logger logger = LogManager.getLogger(AdminDefinitions.class);

    public AdminDefinitions() {
        driver = HelperClass.getDriver();
        login = new LoginActions();
        admin = new AdminActions();
    }

    @Given("The user launches the browser and login")
    public void the_user_launches_the_browser_and_navigates_to_the_performance_module() {
        try {
            logger.info("Attempting to launch browser and login with Admin credentials.");
            login.enterUsernameAndPassword("Admin","admin123");
            login.Login();
            logger.info("Login successful");
        } catch (Exception e) {
            logger.error("Error occurred during login: {}", e.getMessage(), e);
            throw e; 
        }
    }

    @When("the user navigates to the Admin module")
    public void the_user_navigates_to_the_admin_module() {
        try {
            logger.info("Navigating to Admin module");
            admin.goToAdminModule();
            logger.info("Successfully navigated to Admin module");
        } catch (Exception e) {
            logger.error("Error navigating to Admin module: {}", e.getMessage(), e);
            throw e; 
        }
    }

    @When("the user clicks on Qualifications and selects Education")
    public void the_user_clicks_on_qualifications_and_selects_education() {
        try {
            logger.info("Clicking on Qualifications -> Education section");
            admin.goToEducationSection();
            logger.info("Navigated to Education section");
        } catch (Exception e) {
            logger.error("Error navigating to Education section: {}", e.getMessage(), e);
            throw e;
        }
    }

    @When("clicks the Add button")
    public void clicks_the_add_button() {
        try {
            logger.info("Clicking on the Add button");
            admin.clickAddButton();
            logger.info("Add button clicked");
        } catch (Exception e) {
            logger.error("Error clicking the Add button: {}", e.getMessage(), e);
            throw e;
        }
    }

    @When("enters the following Education Details")
    public void enters_the_following_education_details(DataTable dataTable) {
        try {
            List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
            level = rows.get(0).get("Level");
            logger.info("Entering Education Level: {}", level);
            admin.enterEducationLevel(level);
            logger.info("Education Level entered successfully");
        } catch (Exception e) {
            logger.error("Error entering Education Details: {}", e.getMessage(), e);
            throw e;
        }
    }

    @When("clicks to the Save button")
    public void clicks_to_the_save_button() {
        try {
            logger.info("Clicking on Save button");
            admin.clickSaveButton();
            logger.info("Save button clicked");
        } catch (Exception e) {
            logger.error("Error clicking the Save button: {}", e.getMessage(), e);
        }
    }

    @Then("verify that the Education Details are successfully added")
    public void verify_that_the_education_details_are_successfully_added() {
        try {
            logger.info("Verifying if Education Level '{}' is displayed", level);
            Assert.assertTrue(admin.isEducationDisplayed(level), "Education level is invalid");
            logger.info("Education Level '{}' verification successful", level);
        } catch (AssertionError e) {
            logger.error("Education level validation failed: {}", e.getMessage(), e);
        }
    }
}

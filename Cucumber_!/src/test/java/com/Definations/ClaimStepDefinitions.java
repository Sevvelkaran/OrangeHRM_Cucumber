package com.Definations;

import com.Actions.ClaimActions;
import com.Actions.TimeActions;
import com.Utils.HelperClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ClaimStepDefinitions {

    // Creating instances for action classes
    ClaimActions claim = new ClaimActions();
    TimeActions ta = new TimeActions();
    
    WebDriver driver;
    WebDriverWait wait;

    // Hook to set up WebDriver before each scenario
    @Before
    public void setUp() {
        HelperClass.setUpDriver();
        driver = HelperClass.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Hook to tear down WebDriver after each scenario
    @After
    public void tearDown() {
        HelperClass.teardown();
    }

    // Step to launch the OrangeHRM application with a given URL
    @Given("I launch the OrangeHRM app {string}")
    public void i_launch_the_orangehrm_app(String url) {
        HelperClass.openPage(url);
        ta = new TimeActions();
    }

    // Step to log in as an admin user
    @When("I login as Admin")
    public void i_login_as_admin() {
        ta.login("Admin", "admin123");
    }

    // Step to navigate to Claim > Submit Claim page
    @And("I navigate to Claim > Submit Claim")
    public void i_navigate_to_claim_submit_claim() {
        claim.clickClaimModule();
        claim.clickSubmitClaim();
    }

    // Step to select event, currency, and enter remarks in claim form
    @And("I select event and currency and add remarks")
    public void i_select_event_currency_remarks() {
        claim.selectEvent();
        claim.selectCurrency();
        claim.enterRemarks("Test Claim");
    }

    // Step to click on the Create button to submit the claim
    @And("I click on Create button")
    public void i_click_on_create_button() {
        claim.clickCreate();
    }

    // Step to validate that the claim was successfully submitted
    @Then("the claim should be submitted successfully")
    public void claim_submitted_successfully() {
        Assert.assertTrue(claim.isClaimCreated(), "Claim was not created successfully.");
    }

    // Step to navigate to Claim > Assign Claim page
    @And("I navigate to Claim > Assign Claim")
    public void i_navigate_to_claim_assign_claim() {
        claim.clickClaimModule();
        claim.clickAssignClaim();
    }

    // Step to assign a claim for a specific employee
    @And("I assign a claim for an employee")
    public void i_assign_a_claim_for_an_employee() {
        claim.assignClaim();
    }

  
}

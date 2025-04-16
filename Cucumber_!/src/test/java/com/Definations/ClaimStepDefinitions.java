package com.Definations;

import com.Actions.ClaimActions;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ClaimStepDefinitions {

    ClaimActions claim = new ClaimActions();

    @And("I navigate to Claim > Submit Claim")
    public void i_navigate_to_claim_submit_claim() {
        claim.clickClaimModule();
        claim.clickSubmitClaim();
    }

    @And("I select event and currency and add remarks")
    public void i_select_event_currency_remarks() throws InterruptedException {
        claim.selectEvent();
        claim.selectCurrency();
        claim.enterRemarks("Test Claim");
    }

    @And("I click on Create button")
    public void i_click_on_create_button() {
        claim.clickCreate();
    }

    @Then("the claim should be submitted successfully")
    public void claim_submitted_successfully() {
        Assert.assertTrue(claim.isClaimCreated());
    }

    @And("I navigate to Claim > Assign Claim")
    public void i_navigate_to_claim_assign_claim() {
        claim.clickClaimModule();
        claim.clickAssignClaim();
    }

    @And("I assign a claim for an employee")
    public void i_assign_a_claim_for_an_employee() {
        claim.assignClaim();
    }
    
    
    

//    @Then("the expense should be visible in the list")
//    public void the_expense_should_be_visible() {
//        Assert.assertTrue(claim.isExpenseVisible());
//    }
}

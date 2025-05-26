package com.Definations;

import com.Actions.ClaimAction;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import com.Utils.HelperClass;

public class ClaimStepDefinition {

    WebDriver driver = HelperClass.getDriver();
    ClaimAction claimAction = new ClaimAction(driver);

    @Given("the user opens OrangeHRM login page")
    public void openLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user logs in with valid credentials {string} and {string}")
    public void login(String username, String password) {
        claimAction.login(username, password);
    }

    @And("navigates to Claim section and submits a claim")
    public void submitClaim() {
        claimAction.navigateToClaimAndSubmit();
    }

    @Then("a success message should be displayed")
    public void verifySuccess() {
        claimAction.verifyClaimSuccess();
    }
}

package com.Definations;

import com.Actions.CommonActions;
import com.Utils.HelperClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepDefinition {
    CommonActions common = new CommonActions();

    @Given("I launch the OrangeHRM app {string}")
    public void i_launch_the_orangehrm_app(String url) {
        HelperClass.openPage(url);
    }

    @When("I login as Admin")
    public void i_login_as_admin() {
        common.login("Admin", "admin123");
    }
}

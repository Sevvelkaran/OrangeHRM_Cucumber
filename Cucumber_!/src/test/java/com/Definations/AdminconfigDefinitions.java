package com.Definations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Actions.Adminconfigaction;
import com.Actions.LoginActions;
import com.Actions.PIMActions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminconfigDefinitions {
	WebDriver driver;
    Adminconfigaction adcon=new Adminconfigaction();
	@When("the user click on Configuration and select Modules")
	public void the_user_click_on_configuration_and_select_modules() throws InterruptedException {
		adcon.config();
	}

	@When("the user disables the Recruitment module")
	public void the_user_disables_the_recruitment_module() {
	    adcon.disable();
	}

	@When("the user submits the changes by selecting Save")
	public void the_user_submits_the_changes_by_selecting_save() {
	    adcon.save();
	}

	@Then("the Recruitment module should be hidden from the menu")
	public void the_recruitment_module_should_be_hidden_from_the_menu() {
	   adcon.verify();
	}
}

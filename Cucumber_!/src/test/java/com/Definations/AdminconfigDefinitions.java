package com.Definations;

import org.openqa.selenium.WebDriver;


import com.Actions.Adminconfigaction;


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
	
	//localization
	@When("the user clicks on Configuration and selects Localization")
	public void the_user_clicks_on_configuration_and_selects_localization() {
	    adcon.clicklocal();
	}

	@When("the user selects {string} as the language")
	public void the_user_selects_as_the_language(String string) {
	    adcon.selectlang();
	}

	@When("the user selects the date format as {string}")
	public void the_user_selects_the_date_format_as(String string) {
	    adcon.selectdate();
	}

	@When("the user click the Save")
	public void the_user_click_the_save() {
	   adcon.clicksubmit();
	}

	@Then("the user should see the interface in the selected language")
	public void the_user_should_see_the_interface_in_the_selected_language() {
	   String expected="English (United States)";
	   adcon.verifylang(expected);
	}
}

package com.Definations;

import com.Actions.Configaction;
import com.Utils.LogManagers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConfigStepdefinition {
	
	Configaction con = new Configaction();

	@When("the user clicks the Configuration menu and then clicks Optional Fields")
	public void the_user_clicks_the_configuration_menu_and_then_clicks_optional_fields() throws InterruptedException {
		try {
			con.menuclick();
			LogManagers.logInfo("Clicked on Configuration Fields");
			LogManagers.logInfo("Clicked on the Optional Fields");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Optional Fields: " + e.getMessage());
		}
	}

	@When("the user enables the Show Deprecated Fields option")
	public void the_user_enables_the_show_deprecated_fields_option() {
		try {
			con.enable();
			LogManagers.logInfo("Enabled Show Deprecated Fields option");
		} catch (Exception e) {
			LogManagers.logError("Error enabling Deprecated Fields: " + e.getMessage());
		}
	}

	@When("the user clicks the Save button")
	public void the_user_clicks_the_save_button() throws InterruptedException {
		try {
			con.save();
			LogManagers.logInfo("Clicked the save button");
		} catch (Exception e) {
			LogManagers.logError("Error clicking save button: " + e.getMessage());
		}
	}

	@Then("the Show Deprecated Fields option should remain enabled")
	public void the_show_deprecated_fields_option_should_remain_enabled() {
		try {
			con.verify();
			LogManagers.logInfo("Verified Deprecated Fields is enabled");
		} catch (Exception e) {
			LogManagers.logError("Error verifying Deprecated Fields: " + e.getMessage());
		}
	}

	// custom field
	@When("the user clicks the Configuration menu and then clicks Custom Fields")
	public void the_user_clicks_the_configuration_menu_and_then_clicks_custom_fields() {
		try {
			con.customclick();
			LogManagers.logInfo("Clicked the Configuration Menu");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Custom Fields: " + e.getMessage());
		}
	}

	@When("the user clicks the Add button")
	public void the_user_clicks_the_add_button() throws InterruptedException {
		try {
			con.Add();
			LogManagers.logInfo("Clicked Add button");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Add button: " + e.getMessage());
		}
	}

	@When("the user fills out the Add Custom Field form")
	public void the_user_fills_out_the_add_custom_field_form() {
		try {
			con.filldetail();
			LogManagers.logInfo("Custom Field Data Filled");
		} catch (Exception e) {
			LogManagers.logError("Error filling custom field form: " + e.getMessage());
		}
	}

	@When("the user click the save button")
	public void the_user_click_the_save_button() throws InterruptedException {
		try {
			con.savecustom();
			LogManagers.logInfo("Clicked the save button");
		} catch (Exception e) {
			LogManagers.logError("Error saving custom field: " + e.getMessage());
		}
	}

	@Then("the field should be added to the records")
	public void the_field_should_be_added_to_the_records() {
		try {
			con.Verifycustomsave();
			LogManagers.logInfo("Custom Field added to records");
		} catch (Exception e) {
			LogManagers.logError("Error verifying saved custom field: " + e.getMessage());
		}
	}

	// Reporting methods
	@When("the user clicks the Configuration menu and then clicks Reporting methods")
	public void the_user_clicks_the_configuration_menu_and_then_clicks_reporting_methods() {
		try {
			con.clickreport();
			LogManagers.logInfo("Clicked Reporting Methods");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Reporting Methods: " + e.getMessage());
		}
	}

	@When("the user enters the name of the reporting method")
	public void the_user_enters_the_name_of_the_reporting_method() {
		try {
			con.enterreportname();
			LogManagers.logInfo("Entered Reporting Method Name");
		} catch (Exception e) {
			LogManagers.logError("Error entering reporting method: " + e.getMessage());
		}
	}

	@Then("the reporting method should be added to the list")
	public void the_reporting_method_should_be_added_to_the_list() {
		try {
			con.verifyreportmethodname();
			LogManagers.logInfo("Reporting Method Added to List");
		} catch (Exception e) {
			LogManagers.logError("Error verifying reporting method: " + e.getMessage());
		}
	}

	// Termination reasons
	@When("the user clicks the Configuration menu and then clicks Termination Reasons")
	public void the_user_clicks_the_configuration_menu_and_then_clicks_termination_reasons() {
		try {
			con.clickreason();
			LogManagers.logInfo("Clicked Termination Reasons");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Termination Reasons: " + e.getMessage());
		}
	}

	@When("the user enters the Termination reason")
	public void the_user_enters_the_termination_reason() {
		try {
			con.enterterminationreason();
			LogManagers.logInfo("Entered Termination Reason");
		} catch (Exception e) {
			LogManagers.logError("Error entering Termination Reason: " + e.getMessage());
		}
	}

	@Then("the Termination Reason should be added to the list")
	public void the_termination_reason_should_be_added_to_the_list() {
		try {
			con.verifytermination();
			LogManagers.logInfo("Termination Reason Added to List");
		} catch (Exception e) {
			LogManagers.logError("Error verifying Termination Reason: " + e.getMessage());
		}
	}
}

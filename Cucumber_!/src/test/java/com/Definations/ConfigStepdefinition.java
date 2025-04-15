package com.Definations;

import com.Actions.Configaction;
import com.Utils.LogManagers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConfigStepdefinition {
	Configaction con=new Configaction();
	@When("the user clicks the Configuration menu and then clicks Optional Fields")
	public void the_user_clicks_the_configuration_menu_and_then_clicks_optional_fields() throws InterruptedException {
		con.menuclick();
        LogManagers.logInfo("Clicked on Configuration Fields");

        LogManagers.logInfo("Clicked on the Optional Fields");

	}
	@When("the user enables the Show Deprecated Fields option")
	public void the_user_enables_the_show_deprecated_fields_option() {
		con.enable();
        LogManagers.logInfo("Align Leave Asserted");

	}
	@When("the user clicks the Save button")
	public void the_user_clicks_the_save_button() throws InterruptedException {
		con.save();
	    LogManagers.logInfo("Clicked the save button");

	}
	@Then("the Show Deprecated Fields option should remain enabled")
	public void the_show_deprecated_fields_option_should_remain_enabled() {
		con.verify();
	}
	
	//custom field
	@When("the user clicks the Configuration menu and then clicks Custom Fields")
	public void the_user_clicks_the_configuration_menu_and_then_clicks_custom_fields() {
		con.customclick();
	    LogManagers.logInfo("Clicked the Configuration Menu");

	}

	@When("the user clicks the Add button")
	public void the_user_clicks_the_add_button() throws InterruptedException {
		con.Add();
	    LogManagers.logInfo("Clicked Add button");

	}

	@When("the user fills out the Add Custom Field form")
	public void the_user_fills_out_the_add_custom_field_form() {
		con.filldetail();
	    LogManagers.logInfo("Data Filled");

	}
	@When("the user click the save button")
	public void the_user_click_the_save_button() throws InterruptedException {
		con.savecustom();
	    LogManagers.logInfo("Clicked the save button");

	}
	@Then("the field should be added to the records")
	public void the_field_should_be_added_to_the_records() {
		con.Verifycustomsave();
		
	}
	
	//Reporting methods
	@When("the user clicks the Configuration menu and then clicks Reporting methods")
	public void the_user_clicks_the_configuration_menu_and_then_clicks_reporting_methods() {
		con.clickreport();
	}

	@When("the user enters the name of the reporting method")
	public void the_user_enters_the_name_of_the_reporting_method() {
		con.enterreportname();
	    LogManagers.logInfo("Enters Name");

	}

	@Then("the reporting method should be added to the list")
	public void the_reporting_method_should_be_added_to_the_list() {
		con.verifyreportmethodname();
	    LogManagers.logInfo("Reporting Method Added");

	}
	
	//termination resons
	@When("the user clicks the Configuration menu and then clicks Termination Reasons")
	public void the_user_clicks_the_configuration_menu_and_then_clicks_termination_reasons() {
		con.clickreason();
	    LogManagers.logInfo("Clicked the Reason ");

	}

	@When("the user enters the Termination reason")
	public void the_user_enters_the_termination_reason() {
		con.enterterminationreason();
	    LogManagers.logInfo("Termination Reason Entered");

	}

	@Then("the Termination Reason should be added to the list")
	public void the_termination_reason_should_be_added_to_the_list() {
		con.verifytermination();
	    LogManagers.logInfo("Reason Added");

	}
}

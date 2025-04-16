package com.Definations;

import java.util.logging.LogManager;
import org.openqa.selenium.WebDriver;

import com.Actions.PIMActions;
import com.Actions.LoginActions;
import com.Utils.HelperClass;
import com.Utils.LogManagers;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMStepdefinition {

	WebDriver driver;
    LoginActions log = new LoginActions();
    PIMActions pimact = new PIMActions();

    // Navigates to login page, enters credentials, and logs in
	@Given("the user is on the DashBoard page")
	public void the_user_is_on_the_dash_board_page() {
		HelperClass.openPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    log = new LoginActions();
	    log.Valid(); 
	    log.Login();
	    LogManagers.logInfo("WebPage Opened");
	    LogManagers.logInfo("Credentials Entered");
	    LogManagers.logInfo("Clicked Login button");
	}

    // Clicks the PIM menu on dashboard
	@When("the user click the PIM menu")
	public void the_user_click_the_pim_menu() {
		pimact.pimclick();
	    LogManagers.logInfo("Clicked PIM Menu");
	}

    // Clicks Add button under PIM
	@When("the user click the Add Button")
	public void the_user_click_the_add_button() {
		pimact.addclick();
	    LogManagers.logInfo("Add Button Clicked");
	}

    // Fills the employee form using data table
	@When("the user fill the Employee form with details:")
	public void the_user_fill_the_employee_form_with_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    pimact.senddata(dataTable);
	    Thread.sleep(2000);
	    LogManagers.logInfo("Data Have Been Entered");
	}

    // Clicks Save button (Step 1)
	@When("the user click the Save Button")
	public void the_user_click_the_save_Button() throws InterruptedException {
		pimact.save1();
	    LogManagers.logInfo("Clicked the save button");
	}

    // Clicks Save button (Step 2)
	@When("the user click the Save button")
	public void the_user_click_the_save_button() throws InterruptedException {
		pimact.saveclick();
	    LogManagers.logInfo("Clicked the save button");
	}

    // Clicks Add Employee button
	@When("the user click the Add Employee button")
	public void the_user_click_the_add_employee_button() {
		pimact.addempclcik();
	    LogManagers.logInfo("Clicked the Add Employee");
	}

    // Clicks Report-to tab
	@When("the user click the Report-to")
	public void the_user_click_the_report_to() {
		pimact.clickreportto();
	    LogManagers.logInfo("Clicked the Report To");
	}

    // Clicks Add under Assigned Supervisors
	@When("the user click the Add button under Assigned Supervisors")
	public void the_user_click_the_add_button_under_assigned_supervisors() {
		pimact.clicksuperadd();
	    LogManagers.logInfo("Clicked Add button under supervisior");
	}

    // Fills the supervisor assignment form
	@When("the user fill the Supervisor form with:")
	public void the_user_fill_the_supervisor_form_with(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		pimact.senddataforsuper(dataTable);
	    LogManagers.logInfo("Supervisor field is filled");
	}

    // Verifies error message on form submission
	@Then("the user should get the error message{string}")
	public void the_user_should_get_the_error_message(String string) {
	    pimact.verifyerror(string);
	    LogManagers.logInfo("Error message recived ");
	}

    // Verifies supervisor record was added
	@Then("the user should be added to the supervisor Records")
	public void the_user_should_be_added_to_the_supervisor_records() {
		pimact.verifysuper();
	    LogManagers.logInfo("Verified the user added to supervisior");
	}
	
    // Fills employee form using individual values
	@When("the user fills the employee form with {string}, {string}, {string}, and {string}")
	public void the_user_fills_the_employee_form_with_and(String firstname, String middlename, String lastname, String id) {
	    pimact.sendemployeedettails(firstname, middlename, lastname, id);
	    LogManagers.logInfo("Filled the Employee Form");
	}
}

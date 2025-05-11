package com.Definations;


import org.openqa.selenium.WebDriver;

import com.Actions.PIMActions;
import com.Actions.LoginActions;
import com.Utils.HelperClass;
import com.Utils.LogManagers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMStepdefinition {
	WebDriver driver;
    LoginActions log = new LoginActions();
    PIMActions pimact = new PIMActions();

	@Given("the user is on the DashBoard page")
	public void the_user_is_on_the_dash_board_page() {
		try {
			HelperClass.openPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			log.enterUsernameAndPassword("Admin","admin123"); 
			log.Login();
			LogManagers.logInfo("WebPage Opened");
			LogManagers.logInfo("Credentials Entered");
			LogManagers.logInfo("Clicked Login button");
		} catch (Exception e) {
			LogManagers.logError("Error during login setup: " + e.getMessage());
			throw  e;
		}
	}

	@When("the user click the PIM menu")
	public void the_user_click_the_pim_menu() {
		try {
			pimact.pimclick();
			LogManagers.logInfo("Clicked PIM Menu");
		} catch (Exception e) {
			LogManagers.logError("Error clicking PIM menu: " + e.getMessage());
			throw e;
		}
	}

	@When("the user click the Add Button")
	public void the_user_click_the_add_button() {
		try {
			pimact.addclick();
			LogManagers.logInfo("Add Button Clicked");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Add button: " + e.getMessage());
			throw e;
		}
	}

	@When("the user fill the Employee form with details:")
	public void the_user_fill_the_employee_form_with_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		try {
			pimact.senddata(dataTable);
			LogManagers.logInfo("Data Have Been Entered");
		} catch (Exception e) {
			LogManagers.logError("Error filling Employee form: " + e.getMessage());
			throw e;
		}
	}

	@When("the user click the Save Button")
	public void the_user_click_the_save_Button() throws InterruptedException {
		try {
			pimact.save1();
			LogManagers.logInfo("Clicked the save button");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Save Button (save1): " + e.getMessage());
			throw e;
		}
	}
    
	@When("the user click the Save button")
	public void the_user_click_the_save_button() throws InterruptedException {
		try {
			pimact.saveclick();
			LogManagers.logInfo("Clicked the save button");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Save button (saveclick): " + e.getMessage());
			throw e;
		}
	}
 
	@When("the user click the Add Employee button")
	public void the_user_click_the_add_employee_button() {
		try {
			pimact.addempclcik();
			LogManagers.logInfo("Clicked the Add Employee");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Add Employee button: " + e.getMessage());
			throw e;
		}
	}

	@When("the user click the Report-to")
	public void the_user_click_the_report_to() {
		try {
			pimact.clickreportto();
			LogManagers.logInfo("Clicked the Report To");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Report-to: " + e.getMessage());
			throw e;
		}
	}

	@When("the user click the Add button under Assigned Supervisors")
	public void the_user_click_the_add_button_under_assigned_supervisors() {
		try {
			pimact.clicksuperadd();
			LogManagers.logInfo("Clicked Add button under supervisior");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Add under supervisors: " + e.getMessage());
			throw e;
		}
	}

	@When("the user fill the Supervisor form with:")
	public void the_user_fill_the_supervisor_form_with(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		try {
			pimact.senddataforsuper(dataTable);
			LogManagers.logInfo("Supervisor field is filled");
		} catch (Exception e) {
			LogManagers.logError("Error filling Supervisor form: " + e.getMessage());
			throw e;
		}
	}

	@Then("the user should get the error message{string}")
	public void the_user_should_get_the_error_message(String string) {
		try {
			pimact.verifyerror(string);
			LogManagers.logInfo("Error message received");
		} catch (Exception e) {
			LogManagers.logError("Error verifying error message: " + e.getMessage());
			throw e;
		}
	}

	@Then("the user should be added to the supervisor Records")
	public void the_user_should_be_added_to_the_supervisor_records() {
		try {
			pimact.verifysuper();
			LogManagers.logInfo("Verified the user added to supervisor");
		} catch (Exception e) {
			LogManagers.logError("Error verifying supervisor record: " + e.getMessage());
			throw e;
		}
	}

	@When("the user fills the employee form with {string}, {string}, {string}, and {string}")
	public void the_user_fills_the_employee_form_with_and(String firstname, String middlename, String lastname, String id) {
		try {
			pimact.sendemployeedettails(firstname, middlename, lastname, id);
			LogManagers.logInfo("Filled the Employee Form");
		} catch (Exception e) {
			LogManagers.logError("Error filling employee form with parameters: " + e.getMessage());
			throw e;
		}
	}
	//Add emergency contacts
	@When("the user clicks the Emergency Contacts section")
	public void the_user_clicks_the_emergency_contacts_section() {
		pimact.clickemergency();
	}

	@When("the user clicks the Add button in Emergency Contacts")
	public void the_user_clicks_the_add_button_in_emergency_contacts() {
	    pimact.emergencyAdd();
	}

	@When("the user fills the emergency contact form with:")
	public void the_user_fills_the_emergency_contact_form_with(io.cucumber.datatable.DataTable dataTable) {
	   pimact.senddatas(dataTable);
	}

	@When("the user clicks the Save button in Emergency Contacts")
	public void the_user_clicks_the_save_button_in_emergency_contacts() {
	  pimact.emergencysave();
	}

	@Then("the contact should be saved in the Emergency Contacts records")
	public void the_contact_should_be_saved_in_the_emergency_contacts_records() {
	  pimact.emergencyverify();
	}

}
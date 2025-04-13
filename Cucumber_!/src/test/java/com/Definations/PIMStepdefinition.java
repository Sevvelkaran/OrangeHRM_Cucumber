package com.Definations;
import org.openqa.selenium.WebDriver;

import com.Actions.PIMActions;
import com.Actions.LoginActions;
import com.Utils.HelperClass;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMStepdefinition {
	WebDriver driver;
    LoginActions log=new LoginActions();
    PIMActions pimact=new PIMActions();
	@Given("the user is on the DashBoard page")
	public void the_user_is_on_the_dash_board_page() {
		HelperClass.openPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    log = new LoginActions();
	    log.Valid(); 
	    log.Login();
	}

	@When("the user click the PIM menu")
	public void the_user_click_the_pim_menu() {
		pimact.pimclick();
	}

	@When("the user click the Add Button")
	public void the_user_click_the_add_button() {
		pimact.addclick();
	}

	@When("the user fill the Employee form with details:")
	public void the_user_fill_the_employee_form_with_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    pimact.senddata(dataTable);
	    Thread.sleep(2000);
	}
	@When("the user click the Save Button")
	public void the_user_click_the_save_Button() throws InterruptedException {
		pimact.save1();
	}

	@When("the user click the Save button")
	public void the_user_click_the_save_button() throws InterruptedException {
		
		pimact.saveclick();
	}

	@When("the user click the Add Employee button")
	public void the_user_click_the_add_employee_button() {
		pimact.addempclcik();
	}

	@When("the user click the Report-to")
	public void the_user_click_the_report_to() {
		pimact.clickreportto();
	}

	@When("the user click the Add button under Assigned Supervisors")
	public void the_user_click_the_add_button_under_assigned_supervisors() {
		pimact.clicksuperadd();
	}

	@When("the user fill the Supervisor form with:")
	public void the_user_fill_the_supervisor_form_with(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		pimact.senddataforsuper(dataTable);
	}

	@Then("the user should get the error message{string}")
	public void the_user_should_get_the_error_message(String string) {
	    pimact.verifyerror(string);
	}
	@Then("the user should be added to the supervisor Records")
	public void the_user_should_be_added_to_the_supervisor_records() {
		pimact.verifysuper();
	}
	
	@When("the user fills the employee form with {string}, {string}, {string}, and {string}")
	public void the_user_fills_the_employee_form_with_and(String firstname, String middlename, String lastname, String id) {
	    pimact.sendemployeedettails(firstname,middlename,lastname,id);
	}
}
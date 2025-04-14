package com.Definations;
import com.Actions.UsermanagementAction;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsermanagementStepdefinition {
	UsermanagementAction user=new UsermanagementAction();
	@When("the user click the Admin menu")
	public void the_user_click_the_admin_menu() {
		user.clickAdmin();
	}

	@When("the user click on User Management and select Users")
	public void the_user_click_on_user_management_and_select_users() throws InterruptedException {
		user.clickUsers();
	}

	@When("the user click the Add button")
	public void the_user_click_the_add_button() {
		user.clickAdd();
	}

	@When("the user fills in the user details:")
	public void the_user_fills_in_the_user_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		user.Senddata(dataTable);
		
	}
	@When("clicks the Save button")
	public void clicks_the_save_button() {
		user.saveform();
	}
	@Then("the user should be added to the records")
	public void the_user_should_be_added_to_the_records() {
		user.verify();
	}
	//searchvalid
	@When("the user fills in the filter fields with {string},{string},{string},{string}")
	public void the_user_fills_in_the_filter_fields_with(String string, String string2, String string3, String string4) throws InterruptedException {
      user.searchdatas(string,string2,string3,string4);
	}

	@When("click the search button")
	public void click_the_search_button() throws InterruptedException {
		Thread.sleep(3000);
		user.clicksearch();
	}

	@Then("the user should be able to see the specific user in the list")
	public void the_user_should_be_able_to_see_the_specific_user_in_the_list() {
		user.verifysearch();
	}
	@Then("the user should see the message {string}")
	public void the_user_should_see_the_message(String string) {
		user.errorverify(string);
	}
	//delete user
	@When("the user selects the user to be deleted")
	public void the_user_selects_the_user_to_be_deleted() {
		user.select();
		
	}

	@When("the user clicks the Delete button")
	public void the_user_clicks_the_delete_button() {
		user.Deleteclick();
	}

	@When("the user confirms the deletion")
	public void the_user_confirms_the_deletion() {
		user.ConformDelete();
	}

	@Then("the user account should be successfully deleted")
	public void the_user_account_should_be_successfully_deleted() {
		
	}
}

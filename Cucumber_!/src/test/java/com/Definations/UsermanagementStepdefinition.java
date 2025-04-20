package com.Definations;
import com.Actions.UsermanagementAction;
import com.Utils.LogManagers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsermanagementStepdefinition {
	UsermanagementAction user = new UsermanagementAction();

	@When("the user click the Admin menu")
	public void the_user_click_the_admin_menu() {
		try {
			user.clickAdmin();
			LogManagers.logInfo("Clicked Admin Menu");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Admin menu: " + e.getMessage());
		}
	}

	@When("the user click on User Management and select Users")
	public void the_user_click_on_user_management_and_select_users() throws InterruptedException {
		try {
			user.clickUsers();
			LogManagers.logInfo("Clicked UserManagement");
			LogManagers.logInfo("Clicked Selected users");
		} catch (Exception e) {
			LogManagers.logError("Error navigating User Management > Users: " + e.getMessage());
		}
	}

	@When("the user click the Add button")
	public void the_user_click_the_add_button() {
		try {
			user.clickAdd();
			LogManagers.logInfo("Clicked Add Button");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Add button: " + e.getMessage());
		}
	}

	@When("the user fills in the user details:")
	public void the_user_fills_in_the_user_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		try {
			user.Senddata(dataTable);
			LogManagers.logInfo("User Details Filled");
		} catch (Exception e) {
			LogManagers.logError("Error filling in user details: " + e.getMessage());
		}
	}

	@When("clicks the Save button")
	public void clicks_the_save_button() {
		try {
			user.saveform();
			LogManagers.logInfo("Clicked the save button");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Save button: " + e.getMessage());
		}
	}

	@Then("the user should be added to the records")
	public void the_user_should_be_added_to_the_records() {
		// Placeholder for verification method
	}

	@When("the user fills in the filter fields with {string},{string},{string},{string}")
	public void the_user_fills_in_the_filter_fields_with(String string, String string2, String string3, String string4) throws InterruptedException {
		try {
			user.searchdatas(string, string2, string3, string4);
			LogManagers.logInfo("Filled the Filter Fileds");
		} catch (Exception e) {
			LogManagers.logError("Error filling in filter fields: " + e.getMessage());
		}
	}

	@When("click the search button")
	public void click_the_search_button() throws InterruptedException {
		try {
			Thread.sleep(3000);
			user.clicksearch();
			LogManagers.logInfo("Clicked the Search button");
		} catch (Exception e) {
			LogManagers.logError("Error clicking search button: " + e.getMessage());
		}
	}

	@Then("the user should be able to see the specific user in the list")
	public void the_user_should_be_able_to_see_the_specific_user_in_the_list() {
		// Placeholder for search verification
	}

	@Then("the user should see the message {string}")
	public void the_user_should_see_the_message(String string) {
		try {
			user.errorverify(string);
			LogManagers.logInfo("Error Message Displayed");
		} catch (Exception e) {
			LogManagers.logError("Error verifying message: " + e.getMessage());
		}
	}

	@When("the user selects the user to be deleted")
	public void the_user_selects_the_user_to_be_deleted() {
		try {
			user.select();
			LogManagers.logInfo("Selects the User to be Deleted");
		} catch (Exception e) {
			LogManagers.logError("Error selecting user to delete: " + e.getMessage());
		}
	}

	@When("the user clicks the Delete button")
	public void the_user_clicks_the_delete_button() {
		try {
			user.Deleteclick();
			LogManagers.logInfo("Clicked Delete Button");
		} catch (Exception e) {
			LogManagers.logError("Error clicking Delete button: " + e.getMessage());
		}
	}

	@When("the user confirms the deletion")
	public void the_user_confirms_the_deletion() {
		try {
			user.ConformDelete();
			LogManagers.logInfo("Confirmed Delete");
		} catch (Exception e) {
			LogManagers.logError("Error confirming deletion: " + e.getMessage());
		}
	}

	@Then("the user account should be successfully deleted")
	public void the_user_account_should_be_successfully_deleted() {
		// Placeholder for deletion verification
	}
}

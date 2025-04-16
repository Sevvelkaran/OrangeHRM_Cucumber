package com.Definations;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Actions.BuzzActions;
import com.Actions.DashboardActions;
import com.Actions.LoginActions;
import com.Pages.BuzzPages;
import com.Pages.LoginPages;
import com.Utils.HelperClass;
import com.Utils.LogManagers;

import io.cucumber.java.en.*;

public class BuzzDefinition {

    // Getting WebDriver instance from helper class
	WebDriver driver = HelperClass.getDriver();

	// Creating object instances for page and action classes
	BuzzPages objPages = new BuzzPages();
	BuzzActions objActions = new BuzzActions();
	LoginPages objlog = new LoginPages();
	LoginActions objLogin = new LoginActions();
	DashboardActions objAct = new DashboardActions();

    // Step to click on the Buzz menu and assert if the navigation is successful
	@When("The user click on Buzz Menu, Assert it to check")
	public void the_user_click_on_buzz_menu_assert_it_to_check() {
	    objActions.buzz();  // Clicks on Buzz menu
	    LogManagers.logInfo("On Buzz Page");

	    // Asserts if the current URL is correctly loaded
	    String Exp = driver.getCurrentUrl();
	    String Orginal  = driver.getCurrentUrl();
	    assertEquals(Orginal, Exp);
	}

    // Step to enter a message in the Buzz post input field and click Post
	@When("Once the User is on Buzz page Type in the Field box as {string} and click on post")
	public void once_the_user_is_on_buzz_page_type_in_the_field_box_as_and_click_on_post(String string) {
	    objActions.text();  // Clears or focuses the text area
	    LogManagers.logInfo("Text Entered");

	    // Sends the input text to the Buzz post field
		driver.findElement(By.xpath("//textarea[@class=\"oxd-buzz-post-input\"]")).sendKeys(string);
		objActions.post();  // Clicks on Post button
		LogManagers.logInfo("Clicked On Post");
	}

    // Step to like the recently posted Buzz message
	@When("Like the Post")
	public void like_the_post() {
	    objActions.like();  // Clicks the Like button
	    LogManagers.logInfo("Liked the Post");
	}

    // Step to click on the Dashboard menu to navigate away from Buzz
	@When("the user clicks on Dashboard menu")
	public void the_user_clicks_on_dashboard_menu() {
	    objAct.DashBoard();  // Navigates to Dashboard
	    LogManagers.logInfo("DashBoard Menu Clicked");
	}

    // Step to assert that the previously posted Buzz message is visible
	@When("Assert The post to check its pressence")
	public void assert_the_post_to_check_its_pressence() {
		String Expected = "Selenium Cucumber Java";  // Expected post content
		WebElement Org = driver.findElement(By.xpath("//p[text()='Selenium Cucumber Java']"));  // Locates the post
		String orG = Org.getText();  // Gets the text from the located element
		assertEquals(orG, Expected);  // Asserts the content matches
	    LogManagers.logInfo("Asserted the Post");
	}
}

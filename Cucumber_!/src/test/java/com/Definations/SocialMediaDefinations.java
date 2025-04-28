package com.Definations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.Actions.SocialMediaActions;
import com.Pages.SocialMediaPages;
import com.Utils.HelperClass;

import io.cucumber.java.en.*;

public class SocialMediaDefinations {
	WebDriver driver = HelperClass.getDriver();
	SocialMediaActions act = new SocialMediaActions();
	SocialMediaPages pg = new SocialMediaPages();
	

@Given("I want to be on the Login Page of OrangeHRM {string}")
public void i_want_to_be_on_the_login_page_of_orange_hrm(String url) {
	HelperClass.openPage(url);
	act = new SocialMediaActions();
}

@When("The user clicks on the LinkedIn icon")
public void the_user_clicks_on_the_linked_in_icon() {
    act.linkedin();
}

@Then("Navigate back to the Login Page")
public void navigate_back_to_the_login_page() {
	
   driver.navigate().back();
}

@When("The user clicks on the Facebook icon")
public void the_user_clicks_on_the_facebook_icon() {
   act.facebook();
}


@When("The user clicks on the Twitter icon")
public void the_user_clicks_on_the_twitter_icon() {
    act.twitter();
}



@When("The user clicks on the YouTube icon")
public void the_user_clicks_on_the_you_tube_icon() {
    act.youtube();
}





}

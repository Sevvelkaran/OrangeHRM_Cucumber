package com.Definations;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.Actions.LoginActions;
import com.Actions.RecruitmentActions;
import com.Pages.LoginPages;
import com.Pages.RecruitmentPages;
import com.Utils.HelperClass;
import com.Utils.LogManagers;

import io.cucumber.java.en.*;

public class RecruitmentStepDefination {
	WebDriver driver = HelperClass.getDriver();
	RecruitmentActions ract = new RecruitmentActions();
	RecruitmentPages rp = new RecruitmentPages();
	LoginPages objlog = new LoginPages();
	LoginActions objLogin = new LoginActions();
	
@When("The user enters  username {string} and password {string} to login")
	public void the_user_enters_username_and_password_to_login(String Username, String Password) {
	    ract.UsernameAndPassword(Username, Password);
	    ract.clickLogin();
	}

@When("The user clicks on the Recruitment tab and clicks on the Candidates page")
public void the_user_clicks_on_the_recruitment_tab_and_clicks_on_the_candidates_page() {
	ract.openRecruitmentAndCandidatesPage();
   
}

@When("Clicks on Add")
public void clicks_on_add() {
    ract.clickAddButton();
}

@When("The user enters Firstname as {string}, MiddleName as {string} and LastName as {string}")
public void the_user_enters_firstname_as_middle_name_as_and_last_name_as(String FirstName, String MiddleName, String LastName) {
   ract.enterCandidateName(FirstName, MiddleName, LastName);
   
}
@When("Selects Vacancy")
public void selects_vacancy() {
    try {
        ract.selectFirstVacancyOption();
        LogManagers.logInfo("Vacancy selected.");
    } catch (Exception e) {
        LogManagers.logError("Failed to select vacancy: " + e.getMessage());
    }
}


@When("The user enters Email as {string} and Contact as {string}")
public void the_user_enters_email_as_and_contact_as(String Email, String ContactNumber) throws InterruptedException {
	ract.enterEmailAndContact(Email, ContactNumber);
    
}

@When("Enters keyword as {string}")
public void enters_keyword_as(String string) {
	ract.enterKeywords(string);
    
}

@When("Clicks on Save")
public void clicks_on_save() {
    ract.clickSave();
}

@Then("Assert to check its presence")
public void assert_to_check_its_presence() {
    
    try {
        String actualCandidateName = ract.getCandidateNameText();
        assertTrue(actualCandidateName.contains("Dhanush Chandru Gowri"), "Candidate not found!");
        LogManagers.logInfo("Candidate added successfully.");
    } catch (Exception e) {
        LogManagers.logError("Candidate not present: " + e.getMessage());
    }
}
}
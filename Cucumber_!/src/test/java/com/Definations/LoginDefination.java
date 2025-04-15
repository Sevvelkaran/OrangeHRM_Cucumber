package com.Definations;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Actions.LoginActions;
import com.Pages.LoginPages;
import com.Utils.HelperClass;
import com.Utils.LogManagers;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginDefination {
WebDriver driver;
	LoginPages objlog = new LoginPages();
	LoginActions objLogin = new LoginActions();
	  @Before
	    
	         public void setUp() {
	            HelperClass.setUpDriver();
	            driver = HelperClass.getDriver();
	        }

	@After
    public void tearDown() {
        HelperClass.teardown(); 
    }
	
@Given("I want to go to OrangeHRM {string}")
public void i_want_to_go_to_orange_hrm(String url) {
    HelperClass.openPage(url);
    objLogin = new LoginActions();
LogManagers.logInfo("WebPage Opend");
}
@When("The user enters username and password")
public void the_user_enters_username_and_password() throws InterruptedException {
	//Thread.sleep(4000);

    objLogin.Valid();
    LogManagers.logInfo("Credentials Entred");

}

@When("Clicks on the Login button")
public void clicks_on_the_login_button() {
    objLogin.Login();
    LogManagers.logInfo("Login button Clicked");

}

@Then("Assert them for valid login")
public void assert_them_for_valid_login() {
	
	String Expected = "OrangeHRM";
	String Orginal = driver.getTitle();
	
	assertEquals(Orginal, Expected);
	System.out.println("Have been Asserted");
}

@Then("Logout")
public void logout() {
    objLogin.dro();
    objLogin.logout();
    LogManagers.logInfo("Logout button Clicked");

}

@When("The user enters invalid username and invalid password")
public void the_user_enters_invalid_username_and_invalid_password() {
    objLogin.Invalid();
    LogManagers.logInfo("Invalid Credentials Entered");


}

@Then("Assert them for invalid login")
public void assert_them_for_invalid_login() {
    String Str = "Invalid credentials";
    WebElement Invalid = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
    String Org = Invalid.getText();
    assertEquals(Org, Str);
}

@When("The user enters Empty username and invalid password as")
public void the_user_enters_empty_username_and_invalid_password_as() {
    objLogin.empty();
    LogManagers.logInfo("Invalid Credentials Entered");

}

@Then("Assert them for empty login")
public void assert_them_for_empty_login() {
	String Exp1 = driver.getCurrentUrl();
	String Org1 = driver.getCurrentUrl();
	assertEquals(Org1, Exp1);
    
}

@When("The user clicks on the Forgot Password link")
public void the_user_clicks_on_the_forgot_password_link() {
    objLogin.forgot();
    LogManagers.logInfo("Forgot Password Clicked");

}

@Then("Assert the Forgot Password page is displayed")
public void assert_the_forgot_password_page_is_displayed() {
	String str1  = "Reset Password";
	WebElement Forgot = driver.findElement(By.xpath("//h6[text()='Reset Password']"));
	String oorg = Forgot.getText();
	
	assertEquals(oorg, str1);
	driver.navigate().back();
}



}

package com.Definations;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Actions.DashboardActions;
import com.Actions.LoginActions;
import com.Pages.LoginPages;
import com.Utils.HelperClass;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class DashboardDefinations {
	
	WebDriver driver = HelperClass.getDriver();

	LoginPages objlog = new LoginPages();
	LoginActions objLogin = new LoginActions();
	DashboardActions objAct = new DashboardActions();


	  
@Given("I want to go into OrangeHRM {string}")
public void i_want_to_go_into_orange_hrm(String url) {
    HelperClass.openPage(url);
    objLogin = new LoginActions();

}

@When("The user enters the username and password to login")
public void the_user_enters_the_username_and_password_to_login() {
    objLogin.Valid();
    objLogin.Login();

}

@When("The user is on the dashboard and clicks on the clock icon in the Time at Work section")
public void the_user_is_on_the_dashboard_and_clicks_on_the_clock_icon_in_the_time_at_work_section() {
    objAct.clock();
}

@When("The user enters the out time and punches out")
public void the_user_enters_the_out_time_and_punches_out() {
    objAct.time();
    objAct.arrow();
    objAct.out();
    objAct.DashBoard();
    
}

@Then("Assert that the user is on the Dashboard page")
public void assert_that_the_user_is_on_the_dashboard_page() {
	WebDriver driver = HelperClass.getDriver();
    String Expected = "OrangeHRM";
   
    String Orginal = driver.getTitle();
    assertEquals(Orginal, Expected);
    
}

@When("Assert the name Dashboard {string}")
public void assert_the_name_dashboard(String dashboard) {
	WebElement dash = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
	assertEquals(dash.getText(), dashboard);
}

@Then("the user asserts all the quick Action {string}")
public void the_user_asserts_all_the_quick_action(String quickAction) {
    String act = "";
  String exp = quickAction;

  switch (quickAction) {
      case "Assign Leave":
          act = driver.findElement(By.xpath("//p[text()='Assign Leave']")).getText();
          break;
      case "Leave List":
          act = driver.findElement(By.xpath("//p[text()='Leave List']")).getText();
          break;
      case "Timesheets":
          act = driver.findElement(By.xpath("//p[text()='Timesheets']")).getText();
          break;
      case "Apply Leave":
          act = driver.findElement(By.xpath("//p[text()='Apply Leave']")).getText();
          break;
      case "My Leave":
          act = driver.findElement(By.xpath("//p[text()='My Leave']")).getText();
          break;
      case "My Timesheet":
          act = driver.findElement(By.xpath("//p[text()='My Timesheet']")).getText();
          break;

  }

  assertEquals(act, exp);
}









}

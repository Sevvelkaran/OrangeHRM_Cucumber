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

import io.cucumber.java.en.*;

public class BuzzDefinition {

	
	WebDriver driver = HelperClass.getDriver();

	BuzzPages objPages = new BuzzPages();
	BuzzActions objActions = new BuzzActions();
	LoginPages objlog = new LoginPages();
	LoginActions objLogin = new LoginActions();
	DashboardActions objAct = new DashboardActions();

@When("The user click on Buzz Menu, Assert it to check")
public void the_user_click_on_buzz_menu_assert_it_to_check() {
    objActions.buzz();
    
    String Exp = driver.getCurrentUrl();
    String Orginal  = driver.getCurrentUrl();
    assertEquals(Orginal, Exp);
}

@When("Once the User is on Buzz page Type in the Field box as {string} and click on post")
public void once_the_user_is_on_buzz_page_type_in_the_field_box_as_and_click_on_post(String string) {
    objActions.text();

	driver.findElement(By.xpath("//textarea[@class=\"oxd-buzz-post-input\"]")).sendKeys(string);
	objActions.post();
}

@When("Like the Post")
public void like_the_post() {
    objActions.like();
}

@When("the user clicks on Dashboard menu")
public void the_user_clicks_on_dashboard_menu() {
    objAct.DashBoard();

}

@When("Assert The post to check its pressence")
public void assert_the_post_to_check_its_pressence() {
	String Expected = "Selenium Cucumber Java";
	WebElement Org = driver.findElement(By.xpath("//p[text()='Selenium Cucumber Java']"));
	String orG = Org.getText();
	assertEquals(orG, Expected);
}



}
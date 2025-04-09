package com.Actions;

import org.openqa.selenium.support.PageFactory;

import com.Pages.LoginPages;
import com.Utils.HelperClass;

public class LoginActions {

	LoginPages loginpages = null;
	
	  public LoginActions() {
	        loginpages = new LoginPages();
	        PageFactory.initElements(HelperClass.getDriver(), loginpages);
	    }
	 
	 public void Valid() {
		 loginpages.Username.sendKeys("Admin");
		 loginpages.Password.sendKeys("admin123");
	 }
	 public void Invalid() {
		 loginpages.Username.sendKeys("asdf");
		 loginpages.Password.sendKeys("aezakmi");
	 }
	 
	 public void empty() {
		 loginpages.Username.sendKeys("");
		 loginpages.Password.sendKeys("");
	 }
	 public void Login() {
		 loginpages.Loginbtn.click();
	 }
	
	 public void logout() {
		 loginpages.Logout.click();
	 }
	 public void forgot() {
		 loginpages.Forgot.click();
	 }

	public void dro() {
		// TODO Auto-generated method stub
		 loginpages.Drop.click();

		
	}
	 
	
}

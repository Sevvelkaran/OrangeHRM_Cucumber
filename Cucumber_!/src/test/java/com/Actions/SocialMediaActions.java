package com.Actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Pages.SocialMediaPages;
import com.Utils.HelperClass;

public class SocialMediaActions {


	SocialMediaPages  objsocial = null;
	 public SocialMediaActions() {
		 objsocial = new SocialMediaPages();
	        PageFactory.initElements(HelperClass.getDriver(), objsocial);
	    }
	
	 public void linkedin() {
		 objsocial.LinkedIN.click();		 
	 }
	 public void facebook() {
		 objsocial.Facebook.click();
	 }
	 public void twitter() {
		 objsocial.Twitter.click();
	 }
	 public void youtube() {
		 objsocial.Youtube.click();
	 }
	 

	
}

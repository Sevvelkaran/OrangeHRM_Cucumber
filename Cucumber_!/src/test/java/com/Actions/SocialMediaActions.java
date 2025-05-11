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
		 objsocial.linkedIN.click();		 
	 }
	 public void facebook() {
		 objsocial.facebook.click();
	 }
	 public void twitter() {
		 objsocial.twitter.click();
	 }
	 public void youtube() {
		 objsocial.youtube.click();
	 }
	 

	
}

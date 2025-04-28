package com.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Pages.Adminconfigpage;
import com.Utils.HelperClass;

public class Adminconfigaction {
	WebDriver driver;
	Adminconfigpage adcon  = null;
	WebDriverWait wait;
	
	public Adminconfigaction() {
	    driver = HelperClass.getDriver(); 
	    adcon = new Adminconfigpage();
	    PageFactory.initElements(driver,adcon);
	}
   public void config() {
	   adcon.configuration.click();
	   adcon.module.click();
   }
   public void disable() {
	   adcon.recruitment.click();
	   }
   public void save() {
	   adcon.save.click();
   }
   public void verify() {
	   String expected="Recruitment";
	   String actual=adcon.text.getText();
	   Assert.assertNotEquals(expected, actual);;
   }
}

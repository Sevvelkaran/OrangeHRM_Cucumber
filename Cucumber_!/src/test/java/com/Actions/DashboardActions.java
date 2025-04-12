package com.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Pages.DashboardPages;
import com.Pages.LoginPages;
import com.Utils.HelperClass;

public class DashboardActions {
	
	DashboardPages  objPages = null;
	 public DashboardActions() {
		 objPages = new DashboardPages();
	        PageFactory.initElements(HelperClass.getDriver(), objPages);
	    }
	 
	 public void clock() {
		 objPages.ClockIcon.click();
	 }
	 
	  public void time() {
	        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));

	        wait.until(ExpectedConditions.elementToBeClickable(objPages.TimeInsert));

	        objPages.TimeInsert.click();
	    }
	 
	 public void arrow() {
		 objPages.Arrow.click();
	 }
	 
	 public void out() {
		 objPages.Out.click();
	 }
	 
	 public void DashBoard() {
		 objPages.Dashboard.click();
	 }

}
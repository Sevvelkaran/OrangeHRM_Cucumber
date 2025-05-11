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
		 objPages.clockIcon.click();
	 }
	 
	  public void time() {
	        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));

	        wait.until(ExpectedConditions.elementToBeClickable(objPages.timeInsert));

	        objPages.timeInsert.click();
	    }
	 
	 public void arrow() {
		 objPages.arrow.click();
	 }
	 
	 public void out() {
		 objPages.out.click();
	 }
	 
	 public void DashBoard() {
		 objPages.dashboard.click();
	 }

}
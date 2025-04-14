package com.Actions;

import org.openqa.selenium.support.PageFactory;

import com.Pages.BuzzPages;
import com.Pages.DashboardPages;
import com.Utils.HelperClass;

public class BuzzActions {

	BuzzPages  pages;
	public BuzzActions() {
		 pages = new BuzzPages();
	        PageFactory.initElements(HelperClass.getDriver(), pages);
	    }
	

	public void text() {
		pages.TextArea.click();
	}
	public void post() {
		pages.Post.click();
	}
	
	public void like() {
		pages.Heart.click();
	}

	public void buzz() {
		// TODO Auto-generated method stub
		pages.Buzz.click();

	}
	
	
	
}
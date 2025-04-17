package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPages {
	
	@FindBy(xpath="//button[@class=\"oxd-icon-button oxd-icon-button--solid-main orangehrm-attendance-card-action\"]")
	public WebElement ClockIcon;
	
	@FindBy(xpath = "//input[@placeholder=\"hh:mm\"]")
	public WebElement TimeInsert;
	
	//Click
	
	
	//click
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")
	public WebElement Out;

	//Click Dashboard
	@FindBy(xpath = "//span[text()='Dashboard']")
	public WebElement Dashboard;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[1]/button/svg/g/path\n")
	public WebElement AssignLeave;
	@FindBy(xpath = "//i[@class=\"oxd-icon bi-chevron-down oxd-icon-button__icon oxd-time-minute-input-down\"]")
	public WebElement Arrow; 
}

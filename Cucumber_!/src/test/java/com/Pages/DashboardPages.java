package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPages {
	
	@FindBy(xpath="//p[text()='Punch In']/following::button[1]")
	public WebElement ClockIcon;
	
	@FindBy(xpath = "//label[text()='Time']/following-sibling::div//input")
	public WebElement TimeInsert;
	
	//Click
	
	
	//click
	@FindBy(xpath="//p[text()='Punch Out']/following::button[1]")
	public WebElement Out;

	//Click Dashboard
	@FindBy(xpath = "//ul//li[.//span[text()='Dashboard']]/a/span")
	public WebElement Dashboard;
	
	@FindBy(xpath="//p[text()='Assign Leave']/following::button[1]//path")
	public WebElement AssignLeave;
	@FindBy(xpath = "//input[@placeholder='hh:mm']/following::i[contains(@class,'minute-input-down')]")
	public WebElement Arrow; 
}

package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPages {
	
	@FindBy(xpath="//p[text()='Punch In']/following::button[1]")
	public WebElement clockIcon;
	
	@FindBy(xpath = "//label[text()='Time']/following-sibling::div//input")
	public WebElement timeInsert;
	
	//Click
	
	
	//click
	@FindBy(xpath="//p[text()='Punch out']/following::button[1]")
	public WebElement out;

	//Click dashboard
	@FindBy(xpath = "//ul//li[.//span[text()='dashboard']]/a/span")
	public WebElement dashboard;
	
	@FindBy(xpath="//p[text()='Assign Leave']/following::button[1]//path")
	public WebElement assignLeave;
	@FindBy(xpath = "//input[@placeholder='hh:mm']/following::i[contains(@class,'minute-input-down')]")
	public WebElement arrow; 
}

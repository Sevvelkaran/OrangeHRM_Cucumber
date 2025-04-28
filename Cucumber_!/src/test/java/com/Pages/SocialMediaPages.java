package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SocialMediaPages {
	
	
	@FindBy(css ="a:nth-child(1) > .oxd-icon")
	public WebElement LinkedIN;
	
	@FindBy(css = "a:nth-child(2) > .oxd-icon")
	public WebElement Facebook;
	
	@FindBy(css = "a:nth-child(3) > .oxd-icon")
	public WebElement Twitter;
	
	@FindBy(css = "a:nth-child(4) > .oxd-icon")
	public WebElement Youtube;







}

package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages {

	
	@FindBy(xpath="//input[@placeholder=\"Username\"]")
	public WebElement Username;
	
	@FindBy(xpath = "//input[@placeholder=\"Password\"]")
	public WebElement Password;
	
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")
	public WebElement Loginbtn;
	
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	public WebElement Forgot;
	
	@FindBy(xpath = "//p[@class=\"oxd-userdropdown-name\"]")
	public WebElement Drop;
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement Logout;
	
	@FindBy(xpath = "//h6[text()='Reset Password']")
	public WebElement forgotPasswordHeader;
}

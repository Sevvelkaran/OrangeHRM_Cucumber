package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages {

	
	@FindBy(xpath="//input[@placeholder=\"Username\"]")
	public WebElement Username;
	
	@FindBy(xpath = "//input[@placeholder=\"Password\"]")
	public WebElement Password;
	
	@FindBy(xpath="//button[contains(.,'Login')]")
	public WebElement Loginbtn;
	
	@FindBy(xpath="//p[contains(.,'Forgot your password?')]")
	public WebElement Forgot;
	
	@FindBy(xpath = "//p[@class=\"oxd-userdropdown-name\"]")
	public WebElement Drop;
	
	@FindBy(xpath="//a[contains(@href, '/web/index.php/auth/logout')]")
	public WebElement Logout;
	
	@FindBy(xpath = "//h6[text()='Reset Password']")
	public WebElement forgotPasswordHeader;
}
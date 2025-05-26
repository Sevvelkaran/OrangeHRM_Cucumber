package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages {

	
	@FindBy(xpath="//input[@placeholder=\"username\"]")
	public WebElement username;
	
	@FindBy(xpath = "//input[@placeholder=\"password\"]")
	public WebElement password;
	
	@FindBy(xpath="//button[contains(.,'Login')]")
	public WebElement loginbtn;
	
	@FindBy(xpath="//p[contains(.,'forgot your password?')]")
	public WebElement forgot;
	
	@FindBy(xpath = "//p[@class=\"oxd-userdropdown-name\"]")
	public WebElement drop;
	
	@FindBy(xpath="//a[contains(@href, '/web/index.php/auth/logout')]")
	public WebElement logout;
	
	@FindBy(xpath = "//h6[text()='Reset password']")
	public WebElement forgotpasswordHeader;
}
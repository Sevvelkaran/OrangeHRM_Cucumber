package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecuritmentPage {
	
	
	//Recuirtment click
	@FindBy(xpath = "//li[@class=\"oxd-main-menu-item-wrapper\"]/following::span[text()='Recruitment']")
	public WebElement Rclick;
	//Add click
	@FindBy(xpath = "//div[@class=\"orangehrm-header-container\"]/button")
	public WebElement Add;
	
	// click First name, middle name and lastname
	@FindBy(xpath = "//input[@name=\"firstName\"]")
	public WebElement FirstName;
	@FindBy(xpath = "//input[@name=\"middleName\"]")
	public WebElement MiddleName;
	@FindBy(xpath = "//input[@name=\"lastName\"]")
	public WebElement LastName;
	//Selects vacancy 
	@FindBy(xpath = "//div[@class=\"oxd-select-text-input\"]")
	public WebElement Vacancy;
	//Entr email and contact number
	@FindBy(xpath = "//label[text()='Email']/following::input[1]")
	public WebElement email;
	@FindBy(xpath = "//label[text()='Email']/following::input[2]")
	public WebElement Contact;
	//keywords
	@FindBy(xpath = "//label[text()='Keywords']/following::input[1]")
	public WebElement Keyword;
	//click on save
	@FindBy(xpath = "//button[@type=\"submit\"]")
	public WebElement Save;
}

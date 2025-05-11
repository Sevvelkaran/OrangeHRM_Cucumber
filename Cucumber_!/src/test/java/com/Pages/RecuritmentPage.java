package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecuritmentPage {
	
	
	//Recuirtment click
	@FindBy(xpath = "//li[@class=\"oxd-main-menu-item-wrapper\"]/following::span[text()='Recruitment']")
	public WebElement rclick;
	//add click
	@FindBy(xpath = "//div[@class=\"orangehrm-header-container\"]/button")
	public WebElement add;
	
	// click First name, middle name and lastName
	@FindBy(xpath = "//input[@name=\"firstName\"]")
	public WebElement firstName;
	@FindBy(xpath = "//input[@name=\"middleName\"]")
	public WebElement middleName;
	@FindBy(xpath = "//input[@name=\"lastName\"]")
	public WebElement lastName;
	//Selects vacancy 
	@FindBy(xpath = "//div[@class=\"oxd-select-text-input\"]")
	public WebElement Vacancy;
	//Entr email and contact number
	@FindBy(xpath = "//label[text()='Email']/following::input[1]")
	public WebElement email;
	@FindBy(xpath = "//label[text()='Email']/following::input[2]")
	public WebElement contact;
	//keywords
	@FindBy(xpath = "//label[text()='keywords']/following::input[1]")
	public WebElement keyword;
	//click on save
	@FindBy(xpath = "//button[@type=\"submit\"]")
	public WebElement save;
}

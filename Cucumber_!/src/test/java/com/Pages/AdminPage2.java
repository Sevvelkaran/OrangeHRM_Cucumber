//package com.Pages;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//public class AdminPage2{
//
//    @FindBy(xpath = "//a[@class=\"oxd-main-menu-item active\"]")
//    public WebElement adminModule;
//
////    @FindBy(xpath = "(//i[@class=\"oxd-icon bi-chevron-down\"])[4]")
////    public WebElement qualificationsMenu;
//
//    @FindBy(xpath = "//a[text()='Nationalities']")
//    public WebElement nationalitiesOption;
//
//    @FindBy(xpath = "//button[normalize-space()='Add']")
//    public WebElement addButton;
//
//    @FindBy(xpath = "//label[text()='Name']/following::input[1]")
//    public WebElement nameInput;
//
//    @FindBy(xpath = "//button[normalize-space()='Save']")
//    public WebElement saveButton;
//    
//    
//    
//    
//    
//  
//    
//    
//
//}




package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage2 {

    @FindBy(xpath = "(//*[@class=\"oxd-icon oxd-main-menu-item--icon\"]//following-sibling::span)[1]")
    public WebElement adminModule;

    @FindBy(xpath = "//a[text()='Nationalities']")
    public WebElement nationalitiesOption;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
    public WebElement addButton;

    @FindBy(xpath = "//label[text()='Name']/following::input[1]")
    public WebElement nameInput;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--ghost\"]//following-sibling::button")
    public WebElement saveButton;

    @FindBy(xpath = "//span[text()='Required']")
    public WebElement requiredMessage;

}


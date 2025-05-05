package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimePage {

    // Login
    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(tagName = "button")
    public WebElement loginBtn;

    // Time menu flow
    @FindBy(xpath = "//span[text()='Time']")
    public WebElement timeModule;

    @FindBy(xpath = "(//span[@class='oxd-topbar-body-nav-tab-item'])[4]")
    public WebElement timesheets;

    @FindBy(xpath = "//a[text()='Employee Timesheets']")
    public WebElement employeeTimesheets;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeNameInput;

    @FindBy(xpath = "//button[normalize-space()='View']")
    public WebElement viewButton;
    
    @FindBy(xpath = "(//button)[6]")
    public WebElement createTimesheetButton;
    
    @FindBy(xpath = "//form[@class='oxd-form']/div[2]/preceding-sibling::div/div/div/div/span")
    public WebElement invalidMessage;
}
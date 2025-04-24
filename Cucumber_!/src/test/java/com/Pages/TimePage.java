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

    @FindBy(xpath = "/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span")
    public WebElement timesheets;

    @FindBy(xpath = "//a[text()='Employee Timesheets']")
    public WebElement employeeTimesheets;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeNameInput;

    @FindBy(xpath = "//button[normalize-space()='View']")
    public WebElement viewButton;
    
    @FindBy(xpath = "//button[normalize-space()='Create Timesheet']")
    public WebElement createTimesheetButton;

    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div/div/div/span")
    public WebElement invalidMessage;
}
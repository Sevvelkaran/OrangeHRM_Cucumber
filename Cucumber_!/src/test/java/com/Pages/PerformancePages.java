package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerformancePages {

    @FindBy(xpath = "//span[text()='Performance']")
    public WebElement performanceTab;

    @FindBy(xpath = "//span[text()=\"Configure \"]")
    public WebElement configureTab;

    @FindBy(xpath = "(//a[@class=\"oxd-topbar-body-nav-tab-link\"])[2]")
    public WebElement trackersLink;

    @FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
    public WebElement addTrackerButton;


    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    public WebElement trackerName;

    @FindBy(xpath = "(//input[@placeholder=\"Type for hints...\"])[1]")
    public WebElement employeeName;

    @FindBy(xpath = "(//input[@placeholder=\"Type for hints...\"])[2]")
    public WebElement reviewers;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[text()=\"Sevvel\"]")
    public WebElement successMessage;
    
    @FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
    public WebElement requiredEmployeeError;
    
    @FindBy(xpath="//input[@class=\"oxd-input oxd-input--active oxd-input--error\"]")
    public WebElement requiredTrackerError;
    
    @FindBy(xpath = "//a[contains(text(), 'Employee Trackers')]")
    public WebElement employeeTrackersLink;

    @FindBy(xpath = "//button[text()=' View ']")
    public WebElement viewButton;





}



package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerformancePages {

    @FindBy(xpath = "(//a[@class=\"oxd-main-menu-item\"]//child::span)[7]")
    public WebElement performanceTab;

    @FindBy(xpath = "(//span[@class='oxd-topbar-body-nav-tab-item'])[1]")
    public WebElement configureTab;

    @FindBy(xpath = "(//a[@class=\"oxd-topbar-body-nav-tab-link\"])[2]")
    public WebElement trackersLink;

    @FindBy(xpath="//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]//parent::button")
    public WebElement addTrackerButton;


    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    public WebElement trackerName;

    @FindBy(xpath = "(//div[@class=\"oxd-autocomplete-text-input--before\"]//following-sibling::input)[1]")
    public WebElement employeeName;

    @FindBy(xpath = "(//div[@class=\"oxd-autocomplete-text-input--before\"]//following-sibling::input)[2]")
    public WebElement reviewers;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[text()=\"Sevvel\"]")
    public WebElement successMessage;
    
    @FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
    public WebElement requiredEmployeeError;
    
    @FindBy(xpath="//input[@class=\"oxd-input oxd-input--active oxd-input--error\"]")
    public WebElement requiredTrackerError;
    
    @FindBy(xpath = "(//li[@class=\"oxd-topbar-body-nav-tab\"]//child::a)[2]")
    public WebElement employeeTrackersLink;

    @FindBy(xpath = "//button[text()=' View ']")
    public WebElement viewButton;

}



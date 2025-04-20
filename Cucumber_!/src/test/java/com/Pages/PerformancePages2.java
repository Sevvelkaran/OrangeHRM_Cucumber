package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerformancePages2 {

    @FindBy(xpath = "//span[text()='Performance']")
    public WebElement performanceTab;

    @FindBy(xpath = "(//span[@class=\"oxd-topbar-body-nav-tab-item\"]//child::i)[2]")
    public WebElement manageReviewsLink;

    @FindBy(xpath = "(//a[@class=\"oxd-topbar-body-nav-tab-link\"])[2]")
    public WebElement myReviewsLink;

    @FindBy(xpath = "(//span[@class='oxd-topbar-body-nav-tab-item']/child::i)[2]") 
    public WebElement jobTitle;

    @FindBy(xpath = "(//div[@class=\"oxd-table-cell oxd-padding-cell\"])[6]") 
    public WebElement reviewStatus;
    

    @FindBy(xpath = "(//li[@class=\"oxd-topbar-body-nav-tab\"]/child::a)[1]") 
    public WebElement myTrackersLink;

    @FindBy(xpath = "//div[@class='oxd-table-cell oxd-padding-cell'][1]") 
    public WebElement trackerName;
    

    @FindBy(xpath = "//a[contains(text(),'Employee Trackers')]")
    public WebElement employeeTrackersLink;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeNameField;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"]")
    public WebElement includeDropdown;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--ghost\"]/following-sibling::button")
    public WebElement searchButton;

    @FindBy(xpath = "(//div[text()=\"Gayu R \"])[1]") 
    public WebElement resultEmployeeName;
    

    


}

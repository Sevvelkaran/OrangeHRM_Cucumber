package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClaimPage {

    @FindBy(xpath = "//span[text()='Claim']")
    public WebElement claimModule;

    @FindBy(xpath = "//a[text()='Submit Claim']")
    public WebElement submitClaimTab;

    @FindBy(xpath = "//label[text()='Event']/following::div[1]//i")
    public WebElement eventDropdown;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")
    public WebElement selectEvent;

    @FindBy(xpath = "//label[text()='Currency']/following::div[1]//i")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Indian Rupee']")
    public WebElement selectCurrency;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/textarea")
    public WebElement remarks;


    @FindBy(xpath = "//button[text()=' Create ']")
    public WebElement createButton;
    
    @FindBy(xpath = "//div[contains(text(),'Successfully Saved')]")
    public WebElement successMsg;


    @FindBy(xpath = "//a[text()='Assign Claim']")
    public WebElement assignClaimTab;

    @FindBy(xpath = "//div[@class='oxd-select-text-input'][1]")
    public WebElement selectEmployee;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div")
    public WebElement selectEventAssignment;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/div[1]")
    public WebElement selectExpense;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[2]")
    public WebElement assignCreate;

    @FindBy(xpath = "//div[contains(text(),'Taxi')]")
    public WebElement expenseVisible;
}

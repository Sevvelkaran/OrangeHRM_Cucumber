package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeavePage {

    @FindBy(xpath = "//span[text()='Leave']")
    public WebElement leaveMenu;

    @FindBy(xpath = "//a[contains(text(),'Assign Leave')]")
    public WebElement assignLeaveMenu;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeNameInput;

    @FindBy(xpath = "//label[text()='Leave Type']/../following-sibling::div//div[@class='oxd-select-text-input']")
    public WebElement leaveTypeDropdown;
    
    @FindBy(xpath = "//div[@class='oxd-select-wrapper']/div/div[1]")
    public WebElement leaveTypeText ;
    
    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[1]")
    public WebElement fromDateInput;

    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[2]")
    public WebElement toDateInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement assignButton;
}

package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage{

    @FindBy(xpath = "//span[text()='Admin']")
    public WebElement adminTab;

    @FindBy(xpath = "//span[text()='Qualifications ']")
    public WebElement qualificationsTab;

    @FindBy(xpath = "//a[text()='Education']")
    public WebElement educationLink;

    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement addButton;

    @FindBy(xpath = "//label[text()='Level']/../following-sibling::div/input")
    public WebElement educationNameInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;
    
    @FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
    public WebElement duplicateError;

    @FindBy(xpath = "//a[text()='Memberships']")
    public WebElement membershipsLink;

    @FindBy(xpath = "//label[text()='Name']/../following-sibling::div/input")
    public WebElement membershipNameInput;
  
}



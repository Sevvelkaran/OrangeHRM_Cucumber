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
 
}



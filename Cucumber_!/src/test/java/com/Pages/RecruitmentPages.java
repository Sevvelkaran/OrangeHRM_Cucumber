package com.Pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentPages {

    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement Username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement Password;

    @FindBy(xpath = "//button[contains(.,'Login')]")
    public WebElement Loginbtn;

    @FindBy(xpath = "//span[text()='Recruitment']")
    public WebElement recruitmentTab;

    @FindBy(xpath = "//a[text()='Candidates']")
    public WebElement candidatesPage;

    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement addButton;

    @FindBy(name = "firstName")
    public WebElement firstName;

    @FindBy(name = "middleName")
    public WebElement middleName;

    @FindBy(name = "lastName")
    public WebElement lastName;

    @FindBy(xpath = "//label[text()='Vacancy']/../following-sibling::div//i")
    public WebElement vacancyDropdown;

    // Updated to allow selection from list of options
    @FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
    public List<WebElement> dropdownOptions;

    @FindBy(xpath = "//label[text()='Email']/../following-sibling::div//input\n")
    public WebElement email;

    @FindBy(xpath = "//label[text()='Contact Number']/ancestor::div[contains(@class,'oxd-grid-item')]/descendant::input")
    public WebElement contactNumber;

    @FindBy(xpath = "//label[text()='Keywords']/../following-sibling::div//input")
    public WebElement keywords;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'Dhanush Chandru Gowri')]")
    public WebElement candidateName;
}

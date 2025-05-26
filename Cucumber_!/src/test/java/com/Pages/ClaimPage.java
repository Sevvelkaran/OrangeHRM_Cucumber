package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Utils.HelperClass;

public class ClaimPage {

    public ClaimPage() {
        PageFactory.initElements(HelperClass.getDriver(), this);
    }

    // Login Page
    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    // Claim Menu
    @FindBy(xpath = "//div[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[11]/a")
    public WebElement claimMenu;

    @FindBy(xpath = "//a[text()='Assign Claim']")
    public WebElement assignClaim;

    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement addButton;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeName;

    @FindBy(xpath = "//label[text()='Event']/following::div[1]//div[@class='oxd-select-text-input']")
    public WebElement eventDropdown;

    @FindBy(xpath = "//div[@role='option']//span[text()='Accommodation']")
    public WebElement selectAccommodation;

    @FindBy(xpath = "//label[text()='Currency']/following::div[1]//div[@class='oxd-select-text-input']")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//span[text()='United States Dollar']")
    public WebElement selectUSD;

    @FindBy(xpath = "//textarea")
    public WebElement description;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast-content')]//p")
    public WebElement successMessage;
}

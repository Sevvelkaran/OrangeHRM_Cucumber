package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Usermanagementpage {
@FindBy(xpath="(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")
public WebElement admin;
@FindBy(xpath="(//li/span)[2]")
public WebElement usermanagement;
@FindBy(xpath="//a[@class='oxd-topbar-body-nav-tab-link']")
public WebElement users;
@FindBy(xpath="(//button/i)[4]")
public WebElement Add;
@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
public WebElement userrole;
@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
public WebElement status;
@FindBy(xpath="(//div/input)[2]")
public WebElement empname;
@FindBy(xpath="(//div/input)[3]")
public WebElement username;
@FindBy(xpath="(//div/input)[4]")
public WebElement pass;
@FindBy(xpath="(//div/input)[5]")
public WebElement conpass;
@FindBy(xpath="//button[@type='submit']")
public WebElement submit;
@FindBy(xpath="(//div[@class='oxd-table-cell oxd-padding-cell'])[8]")
public WebElement text;
@FindBy(xpath="(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[2]")
public WebElement selectcheckbox;
@FindBy(xpath="(//i[@class='oxd-icon bi-trash'])[2]")
public WebElement delete;
@FindBy(xpath="//i[@class='oxd-icon bi-trash oxd-button-icon']")
public WebElement condelete;


//searchvalid
@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
public WebElement un;
@FindBy(xpath="//div[@class='oxd-autocomplete-text-input--before']/following::input")
public WebElement en;
@FindBy(xpath="//button[@type='submit']")
public WebElement search;
@FindBy(xpath="//div[text()='Admin1']")
public WebElement admintext;
@FindBy(xpath="//span[text()='No Records Found']")
public WebElement errortext;
@FindBy(xpath="//span[text()='Invalid']")
public WebElement invalid;
}
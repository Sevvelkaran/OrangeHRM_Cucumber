package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMpage {
  @FindBy(xpath="//span[text()='PIM']")
  public WebElement pim;
  @FindBy(xpath="//i[@class='oxd-icon bi-plus oxd-button-icon']")
  public WebElement add;
  @FindBy(xpath="//input[@name='firstName']")
  public WebElement firstname;
  @FindBy(xpath="//input[@name='lastName']")
  public WebElement lastname;
  @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
  public WebElement id;
  @FindBy(xpath="//button[text()=' Save ']")
  public WebElement save;
  @FindBy(xpath="(//a[@class='oxd-topbar-body-nav-tab-item'])[2]")
  public WebElement addemployee;
  @FindBy(xpath="//a[text()='Report-to']")
  public WebElement reportto;
  @FindBy(xpath="(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[1]")
  public WebElement superviseradd;
  @FindBy(css=".oxd-autocomplete-text-input > input")
  public WebElement name;
  @FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
  public WebElement reportdrop;
  @FindBy(xpath="//div[text()='Direct']")
  public WebElement selmethod;
  @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
  public WebElement savesuper;
  @FindBy(xpath="//i[@class='oxd-icon bi-trash']")
  public WebElement verifyadd;
}

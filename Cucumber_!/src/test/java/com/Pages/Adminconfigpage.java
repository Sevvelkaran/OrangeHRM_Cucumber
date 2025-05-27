package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Adminconfigpage {
  @FindBy(xpath="(//i[@class='oxd-icon bi-chevron-down'])[5]")
  public WebElement configuration;
  @FindBy(xpath="(//a[@class='oxd-topbar-body-nav-tab-link'])[5]")
  public WebElement module;
  @FindBy(xpath="(//span[@class='oxd-switch-input oxd-switch-input--active --label-right'])[5]")
  public WebElement recruitment;
  @FindBy(xpath="(//button)[4]")
  public WebElement save;
  @FindBy(xpath="(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[5]")
  public WebElement text;
  
  //localization
  @FindBy(xpath="//a[text()='Localization']/parent::li")
  public WebElement local;
  @FindBy(xpath="(//div[@class='oxd-select-text-input'])[1]")
  public WebElement lang;
  @FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
  public WebElement date;
  @FindBy(xpath="//button[@type='submit']")
  public WebElement submit;
}

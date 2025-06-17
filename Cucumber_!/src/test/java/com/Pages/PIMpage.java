

package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMpage {
  @FindBy(xpath="(//a/child::span)[2]")
  public WebElement pim;
  @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
  public WebElement add;
  @FindBy(xpath="//input[@name='firstName']")
  public WebElement firstname;
  @FindBy(xpath="//input[@name='middleName']")
  public WebElement middlename;
  @FindBy(xpath="//input[@name='lastName']")
  public WebElement lastname;
  @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
  public WebElement id;
  @FindBy(xpath="//input[@name='firstName']")
  public WebElement nameofemp;
  @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
  public WebElement saveemp1;
  @FindBy(css=".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
  public WebElement save;
  @FindBy(xpath="(//a[@class='oxd-topbar-body-nav-tab-item'])[2]")
  public WebElement addemployee;
  @FindBy(xpath="(//a[@class='orangehrm-tabs-item'])[7]")
  public WebElement reportto;
  @FindBy(xpath="(//h6/following::button)[3]")
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
  @FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 --strong']")
  public WebElement savedemp;
  @FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
  public WebElement nameerr;
  
  //emergeny contacts
  @FindBy(xpath="//div[@class='orangehrm-tabs-wrapper'][3]/child::a")
  public WebElement emergency;
  @FindBy(xpath="(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[1]")
  public WebElement emergencyadd;
  @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
  public WebElement emergencyname;
  @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
  public WebElement relationship;
  @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[4]")
  public WebElement mobile;
 @FindBy(xpath="//div[@class='oxd-table-cell oxd-padding-cell'][2]/div[1]")
 public WebElement emertext;

}
package com.Actions;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Pages.Configpage;
import com.Utils.HelperClass;

import junit.framework.Assert;

public class Configaction {
	WebDriver driver;
	Configpage con = null;
	
	public Configaction() {
	    driver = HelperClass.getDriver(); 
	    con=new Configpage();
	    PageFactory.initElements(driver,con);
	}
  public void menuclick() throws InterruptedException {
	    con.config.click();
	    con.optional.click();
	    Thread.sleep(3000);
  }
  public void enable() {
	  con.button.click();
  }
  public void save() throws InterruptedException {
	  con.save.click();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(con.button));

  }
  public void verify() {
	  if(con.button.isEnabled()) {
		    System.out.println("Show Deprecated Fields is enabled");
		}
	  else {
		  System.out.println("Show Deprecated Fields is disabled");
	  }
  }
  public void customclick() {
	  con.config.click();
	  con.custom.click();
  }
  public void Add() throws InterruptedException {
	  con.add.click();
	  Thread.sleep(3000);
  }
  public void filldetail() {
	  con.fieldname.sendKeys("Address");
	  Actions act=new Actions(driver);
	  con.screendropdown.click();
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  con.typedropdown.click();
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  
  }
  public void savecustom() throws InterruptedException {
	  con.savecustomfield.click();
	  Thread.sleep(3000);
  }
  public void Verifycustomsave() {
	  String expected="Address";
	  String actual=con.verifycustomsave.getText();
	  Assert.assertEquals(expected,actual);
	  System.out.println("Asserted Custom field");
	  con.delete.click();
	  con.condelete.click();
  }
  //reporting method
  public void clickreport() {
	  con.config.click();
	  con.reportingmethod.click();
  }
  public void enterreportname() {
	  con.reportmethodname.sendKeys("Administrative");
  }
  public void verifyreportmethodname() {
	  String expected="Administrative";
	  String actual=con.reporttext.getText();
	  Assert.assertEquals(expected,actual);
	  con.delete.click();
	  con.condelete.click();
  }
  //termination reason
  public void clickreason() {
	  con.config.click();
	  con.termination.click();
  }
  public void enterterminationreason() {
	  con.terminationreason.sendKeys("Attitude");
  }
  public void verifytermination() {
	  String expected="Attitude";
	  String actual=con.terminationtext.getText();
	  Assert.assertEquals(expected,actual);
	  con.delete.click();
	  con.condelete.click();
  }
}

package com.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Pages.Configpage;
import com.Utils.HelperClass;


public class Configaction {
	WebDriver driver;
	Configpage con = null;
	WebDriverWait wait;
	public Configaction() {
	    driver = HelperClass.getDriver(); 
	    con=new Configpage();
	    PageFactory.initElements(driver,con);
	}
  public void menuclick() throws InterruptedException {
	    clickMethod(con.config);
	    clickMethod(con.optional);
	   // Thread.sleep(3000);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
  }
  public void enable() {
	  clickMethod(con.button);
  }
  public void save() throws InterruptedException {
	  clickMethod(con.save);
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
  //custom field
  public void customclick() {
	 clickMethod( con.config);
	 clickMethod(con.custom);
  }
  public void Add() throws InterruptedException {
	  clickMethod(con.add);
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	  //Thread.sleep(3000);
  }
  public void filldetail() {
	  send(con.fieldname,"Address");
	  Actions act=new Actions(driver);
	  clickMethod(con.screendropdown);
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  clickMethod(con.typedropdown);
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  
  }
  public void savecustom() throws InterruptedException {
	  clickMethod(con.savecustomfield);
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	 // Thread.sleep(3000);
  }
  public void Verifycustomsave() {
	  String expected="Address";
//	  String actual=con.verifycustomsave.getText();
//	  Assert.assertEquals(expected,actual);
//	  System.out.println("Asserted Custom field");
//	  clickMethod(con.delete);
//	  clickMethod(con.condelete);
	  int i=2;
	  while(true) {
		 String actual= driver.findElement(By.xpath("(//div[@class='oxd-table-row oxd-table-row--with-border'])["+i+"]//div[@class='oxd-table-cell oxd-padding-cell'][2]")).getText();
		 if(expected.equals(actual)) {
			 Assert.assertEquals(expected,actual);
			 clickMethod(con.delete);
			  clickMethod(con.condelete);
			 break;
		 }
		 i++;
	  }
  }
  //reporting method
  public void clickreport() {
	  clickMethod(con.config);
	  clickMethod(con.reportingmethod);
  }
  public void enterreportname() {
	  send(con.reportmethodname,"Administrative");
  }
  public void verifyreportmethodname() {
	  String expected="Administrative";
//	  String actual=con.reporttext.getText();
//	  Assert.assertEquals(expected,actual);
//	  clickMethod(con.delete);
//	  clickMethod(con.condelete);
	  int i=2;
	  while(true) {
		 String actual= driver.findElement(By.xpath("(//div[@class='oxd-table-row oxd-table-row--with-border'])["+i+"]//div[@class='oxd-table-cell oxd-padding-cell'][2]")).getText();
		 if(expected.equals(actual)) {
			 Assert.assertEquals(expected,actual);
			 clickMethod(con.delete);
			 clickMethod(con.condelete);
			 break;
		 }
		 i++;
	  }
  }
  //termination reason
  public void clickreason() {
	  clickMethod(con.config);
	  clickMethod(con.termination);
  }
  public void enterterminationreason() {
	  send(con.terminationreason,"Attitude");
  }
  public void verifytermination() {
	  String expected="Attitude";
//	  String actual=con.terminationtext.getText();
//	  Assert.assertEquals(expected,actual);
//	  clickMethod(con.delete);
//	  clickMethod(con.condelete);
	  int i=2;
	  while(true) {
		 String actual= driver.findElement(By.xpath("(//div[@class='oxd-table-row oxd-table-row--with-border'])["+i+"]//div[@class='oxd-table-cell oxd-padding-cell'][2]")).getText();
		 if(expected.equals(actual)) {
			 Assert.assertEquals(expected,actual);
			 clickMethod(con.delete);
			 clickMethod(con.condelete);
			 break;
		 }
		 i++;
	  }
  }
  public void clickMethod(WebElement element) {
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(element)).click();
  }
  public void send(WebElement ele,String msg) {
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(msg);
  }
}

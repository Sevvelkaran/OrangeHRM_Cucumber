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

import com.Pages.Adminconfigpage;
import com.Utils.HelperClass;

public class Adminconfigaction {
	WebDriver driver;
	Adminconfigpage adcon  = null;
	WebDriverWait wait;
	
	public Adminconfigaction() {
	    driver = HelperClass.getDriver(); 
	    adcon = new Adminconfigpage();
	    PageFactory.initElements(driver,adcon);
	}
   public void config() throws InterruptedException {
	   clickMethod(adcon.configuration);
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	   clickMethod(adcon.module);
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-loading-spinner")));
   }
   public void disable() {
	   clickMethod(adcon.recruitment);
	   
	   }
   public void save() {
	   clickMethod(adcon.save);
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-loading-spinner")));
   }
   public void verify() {
	   String expected="Recruitment";
	   String actual=adcon.text.getText();
	   Assert.assertNotEquals(expected, actual);
	   clickMethod(adcon.recruitment);
	   clickMethod(adcon.save);
   }
   public void clicklocal() {
	   clickMethod(adcon.configuration);
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	   clickMethod(adcon.local);
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
   }
   public void selectlang() {
//	   adcon.lang.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
   }
   public void selectdate() {
//	   adcon.date.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
   }
   public void clicksubmit() {
	   clickMethod(adcon.submit);
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-loading-spinner")));
   }
   public void verifylang(String expected) {
	   String actual=adcon.lang.getText();
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

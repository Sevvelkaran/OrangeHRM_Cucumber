package com.Actions;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Pages.Usermanagementpage;
import com.Utils.HelperClass;

import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class UsermanagementAction {
	public static String k = "";
	WebDriver driver;
	Usermanagementpage user  = null;
	WebDriverWait wait;
	public UsermanagementAction() {
	    driver = HelperClass.getDriver(); 
	    user = new Usermanagementpage();
	    PageFactory.initElements(driver,user);
	}
	public void clickAdmin() {
		clickMethod(user.admin);
	}
  public void clickUsers() throws InterruptedException {
	  clickMethod(user.usermanagement);
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	  clickMethod(user.users);
  }
  public void clickAdd() {
	  clickMethod(user.Add);
  }
  public void Senddata(DataTable dataTable) throws InterruptedException {
	  Map<String, String> data = dataTable.asMap(String.class, String.class);
	  String baseUsername = data.get("Username");
	  k = baseUsername + "_" + System.currentTimeMillis();
	  clickMethod(user.userrole);
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	  Actions act=new Actions(driver);
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  send(user.empname,data.get("EmployeeName"));
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  clickMethod(user.status);
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  send(user.username,k);
	  send(user.pass,data.get("Password"));
	  send(user.conpass,data.get("Confirm"));
  }
  public void saveform() {
	  clickMethod(user.submit);
	  
  }
  public void verify() {
	  String actual=user.text.getText();
	  String expected=k;
	  Assert.assertEquals(expected,actual);
	  System.out.println("User added successfully");
	  
  }
  //search
  public void searchdatas(String username,String userrole,String empname,String status) throws InterruptedException {
	  send(user.un,username);
	  Actions act=new Actions(driver);
	  if(status!="") {
		  clickMethod(user.status);
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
		  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  }
	  if(userrole!="") {
		  clickMethod(user.userrole);
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
		  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  }  
	  if(empname!="") {
	  send(user.en,empname);
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  }
  }
  public void clicksearch() {
	  clickMethod(user.search);
  }
  public void verifysearch() {
	  String actual=user.admintext.getText();
	  String expected=k;
	  Assert.assertEquals(expected,actual);
	  System.out.println("user found");
  }
  public void errorverify(String expected) {
	  if(expected.equals("No Records Found")) {
		  Assert.assertEquals(expected,user.errortext.getText());
	  }
	  if(expected.equals("Invalid")) {
		  Assert.assertEquals(expected,user.invalid.getText());
	  }
        }
  
  //deleteuser
  public void select() {
	  user.selectcheckbox.click();
  }
  public void Deleteclick() {
	  user.delete.click();
  }
  public void ConformDelete() {
	  user.condelete.click();
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
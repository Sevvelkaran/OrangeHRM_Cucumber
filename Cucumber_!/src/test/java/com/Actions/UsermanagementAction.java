package com.Actions;

import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Pages.PIMpage;
import com.Pages.Usermanagementpage;
import com.Utils.HelperClass;

import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class UsermanagementAction {
	WebDriver driver;
	Usermanagementpage user  = null;
	
	public UsermanagementAction() {
	    driver = HelperClass.getDriver(); 
	    user = new Usermanagementpage();
	    PageFactory.initElements(driver,user);
	}
	public void clickAdmin() {
		user.admin.click();
	}
  public void clickUsers() throws InterruptedException {
	  user.usermanagement.click();
	  Thread.sleep(3000);
	  user.users.click();
  }
  public void clickAdd() {
	  user.Add.click();
  }
  public void Senddata(DataTable dataTable) throws InterruptedException {
	  Map<String, String> data = dataTable.asMap(String.class, String.class);
	  user.userrole.click();
	  Thread.sleep(3000);
	  Actions act=new Actions(driver);
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  user.empname.sendKeys(data.get("EmployeeName"));
	  Thread.sleep(3000);
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  user.status.click();
	  Thread.sleep(3000);
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  user.username.sendKeys(data.get("Username"));
	  user.pass.sendKeys(data.get("Password"));
	  user.conpass.sendKeys(data.get("Confirm"));
  }
  public void saveform() {
	  user.submit.click();
  }
  public void verify() {
	  String actual=user.text.getText();
	  String expected="Admin1";
	  Assert.assertEquals(expected,actual);
	  System.out.println("User added successfully");
	  
  }
  //search
  public void searchdatas(String username,String userrole,String empname,String status) throws InterruptedException {
	  user.un.sendKeys(username);
	  Actions act=new Actions(driver);
	  if(status!="") {
		  user.status.click();
		  Thread.sleep(3000);
		  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  }
	  if(userrole!="") {
		  user.userrole.click();
		  Thread.sleep(3000);
		  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  }  
	  if(empname!="") {
	  user.en.sendKeys(empname);
	  Thread.sleep(3000);
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  }
  }
  public void clicksearch() {
	  user.search.click();
  }
  public void verifysearch() {
	  String actual=user.admintext.getText();
	  String expected="Admin1";
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
}

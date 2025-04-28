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
import org.testng.Assert;

import com.Pages.PIMpage;
import com.Utils.HelperClass;

import io.cucumber.datatable.DataTable;

public class PIMActions {
	WebDriver driver;
	PIMpage pimpage  = null;
	WebDriverWait wait;
	
	public PIMActions() {
	    driver = HelperClass.getDriver(); 
	    pimpage = new PIMpage();
	    PageFactory.initElements(driver, pimpage);
	}
	  public void pimclick() {
		  clickMethod(pimpage.pim);
	  }
	  public void addclick() {
		  clickMethod(pimpage.add);
	  }
	  public void senddata(DataTable dataTable) {
		    Map<String, String> data = dataTable.asMap(String.class, String.class);
		    send(pimpage.firstname,data.get("Firstname"));
		    send(pimpage.lastname,data.get("Lastname"));
		    pimpage.id.clear();
		    send(pimpage.id,data.get("Employeeid"));
		    Actions act=new Actions(driver);
		    act.sendKeys(Keys.ENTER);
		}
	  public void saveclick() throws InterruptedException {
		  clickMethod(pimpage.save);
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	  }
	  
	  public void addempclcik() {
		  clickMethod(pimpage.addemployee);
	  }
	  public void clickreportto() {
		  clickMethod(pimpage.reportto);
	  }
	  public void clicksuperadd() {
		  clickMethod(pimpage.superviseradd);
	  }
	  public void senddataforsuper(DataTable datatable) throws InterruptedException {
		  Map<String, String> data = datatable.asMap(String.class, String.class);
		  Actions actions = new Actions(driver);
		  send(pimpage.name,data.get("Name"));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
		  actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		  clickMethod(pimpage.reportdrop);
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
		  actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		}
	  public void verifysuper() {
		  if(pimpage.verifyadd.isDisplayed()) {
    		  System.out.println("Superviser added");
    	  }
	  }
      public void verify() {
    	  if(pimpage.savedemp.getText().contains("Dharani")||pimpage.savedemp.getText().contains("Thoushi")||pimpage.savedemp.getText().contains("Gayu")) {
           		 System.out.println("Employee added in the list");
    	  }
      }
      
      public void save1() throws InterruptedException {
    	  
    	  clickMethod(pimpage.saveemp1);
    	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-loading-spinner")));
      }
      public void sendemployeedettails(String firstname,String middlename,String lastname,String id) {
    	  send(pimpage.firstname,firstname);
    	  send(pimpage.middlename,middlename);
		    //pimpage.lastname.sendKeys(lastname);
		    Actions act=new Actions(driver);
		    send(pimpage.lastname,lastname);
		    act.sendKeys(Keys.ENTER).build().perform();	  
      }
      public void verifyerror(String expected) {
    	  String actual=pimpage.nameerr.getText();
    	  Assert.assertEquals(expected,actual);
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
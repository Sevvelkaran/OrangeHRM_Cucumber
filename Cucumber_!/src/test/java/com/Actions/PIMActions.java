package com.Actions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Pages.PIMpage;
import com.Utils.HelperClass;

import io.cucumber.datatable.DataTable;

public class PIMActions {
	WebDriver driver;
	PIMpage pimpage  = null;
	
	public PIMActions() {
	    driver = HelperClass.getDriver(); 
	    pimpage = new PIMpage();
	    PageFactory.initElements(driver, pimpage);
	}
	  public void pimclick() {
		  pimpage.pim.click();
	  }
	  public void addclick() {
		  pimpage.add.click();
	  }
	  public void senddata(DataTable dataTable) {
		    Map<String, String> data = dataTable.asMap(String.class, String.class);
		    pimpage.firstname.sendKeys(data.get("Firstname"));
		    pimpage.lastname.sendKeys(data.get("Lastname"));
		    pimpage.id.clear();
		    pimpage.id.sendKeys(data.get("Employeeid"));
		    Actions act=new Actions(driver);
		    act.sendKeys(Keys.ENTER);
		}
	  public void saveclick() throws InterruptedException {
		  Thread.sleep(3000);
		  pimpage.save.click();
		  Thread.sleep(3000);
	  }
	  public void addempclcik() {
		  pimpage.addemployee.click();
	  }
	  public void clickreportto() {
		  pimpage.reportto.click();
	  }
	  public void clicksuperadd() {
		  pimpage.superviseradd.click();
	  }
	  public void senddataforsuper(DataTable datatable) throws InterruptedException {
		  Map<String, String> data = datatable.asMap(String.class, String.class);
		  Actions actions = new Actions(driver);
		  pimpage.name.sendKeys(data.get("Name"));
		  Thread.sleep(3000); 
		  actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		  pimpage.reportdrop.click();
		  Thread.sleep(3000);
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
    	  Thread.sleep(3000);
    	  pimpage.saveemp1.click();
    	  Thread.sleep(3000);
      }
      public void sendemployeedettails(String firstname,String middlename,String lastname,String id) {
    	  pimpage.firstname.sendKeys(firstname);
    	  pimpage.middlename.sendKeys(middlename);
		    //pimpage.lastname.sendKeys(lastname);
		    Actions act=new Actions(driver);
		    pimpage.lastname.sendKeys(lastname);
		    act.sendKeys(Keys.ENTER).build().perform();	  
      }
      public void verifyerror(String expected) {
    	  String actual=pimpage.nameerr.getText();
    	  Assert.assertEquals(expected,actual);
      }
}
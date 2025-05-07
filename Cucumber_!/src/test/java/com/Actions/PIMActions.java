
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
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
	//Add employee
	public void pimclick() {
		  pimpage.pim.click();
	  }

	  public void addclick() {
		  pimpage.add.click();
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
	  
      public void save1() throws InterruptedException {
    	  
    	  clickMethod(pimpage.saveemp1);
    	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-loading-spinner")));
      }
      public void clickreportto() {
		  clickMethod(pimpage.reportto);
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	  }
      public void clicksuperadd() {
		  clickMethod(pimpage.superviseradd);
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	  }
      public void senddataforsuper(DataTable datatable) throws InterruptedException {
		  Map<String, String> data = datatable.asMap(String.class, String.class);
		  Actions actions = new Actions(driver);
		  send(pimpage.name,data.get("Name"));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
		  actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		  pimpage.reportdrop.click();
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
		  actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		}
      public void saveclick() throws InterruptedException {
		    clickMethod(pimpage.save);
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
		}
      public void verifysuper() {
		  List<WebElement> supervisornames = driver.findElements(By.xpath("(//div[@class='oxd-table-body'])[1]//div[2]"));
		  String expected="Gayu R";
		  for(int i=1;i<=supervisornames.size();i++) {
			  String xpath = "((//div[@class='oxd-table-body'])[1]//div[2])[" + i + "]";
			  String actual = driver.findElement(By.xpath(xpath)).getText();
			  if(expected.equals(actual)) {
				  Assert.assertEquals(expected,actual);
				  System.out.println("successfully supervisor added");
			  }
		  }

	 }
	  
    //Search
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
      //emergency

      public void clickemergency() {
    	  clickMethod(pimpage.emergency);
    	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
      }
      public void emergencyAdd() {
    	  pimpage.emergencyadd.click();
    	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
      }
      public void senddatas(DataTable datatable) {
    	  Map<String, String> data = datatable.asMap(String.class, String.class);
		  pimpage.emergencyname.sendKeys(data.get("Name"));
		  pimpage.relationship.sendKeys(data.get("Relationship"));
		  pimpage.mobile.sendKeys(data.get("Mobile"));
      } 
      public void emergencysave() {
    	  clickMethod(pimpage.save);
    	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
      }
      public void emergencyverify() {
    	  List<WebElement> contactname = driver.findElements(By.xpath("(//div[@class='oxd-table-body'])[1]//div[2]"));
    	  String expected="Priya";
		  for(int i=1;i<=contactname.size();i++) {
			  String xpath = "((//div[@class='oxd-table-body'])[1]//div[2])[" + i + "]";
			  String actual = driver.findElement(By.xpath(xpath)).getText();
			  if(expected.equals(actual)) {
				  Assert.assertEquals(expected,actual);
				  System.out.println("successfully emergency contact added");
			  }
		  }
      }
	public void clickMethod(WebElement element) {
  	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	  wait.until(ExpectedConditions.elementToBeClickable(element));
  	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void send(WebElement ele,String msg) {
  	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(msg);
    }
	
}
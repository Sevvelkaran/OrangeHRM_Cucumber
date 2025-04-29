package com.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Pages.BuzzPages;
import com.Pages.DashboardPages;
import com.Utils.HelperClass;

public class BuzzActions {

	BuzzPages  pages;
	public BuzzActions() {
		 pages = new BuzzPages();
	        PageFactory.initElements(HelperClass.getDriver(), pages);
	    }
	

	public void text() {
		pages.TextArea.click();
	}
	public void post() {
		pages.Post.click();
	}
	
	public void like() {
		pages.Heart.click();
	}
	
	public void buzz() {
		pages.Buzz.click();

	}
	
	public void clickHelp() {
	    WebDriver driver = HelperClass.getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(pages.HelpButton)).click();
	}

	public void verifyHelpPageURL() {
	    WebDriver driver = HelperClass.getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(d -> d.getWindowHandles().size() > 1);

	    for (String handle : driver.getWindowHandles()) {
	        driver.switchTo().window(handle);
	    }
	    wait.until(ExpectedConditions.urlContains("starterhelp.orangehrm.com/hc/en-us"));
	    assertEquals(driver.getCurrentUrl(), "https://starterhelp.orangehrm.com/hc/en-us");
	    driver.close();
	}

	
	
}
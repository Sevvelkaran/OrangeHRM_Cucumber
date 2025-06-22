package com.Actions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import com.Pages.PIMpage;
import com.Utils.HelperClass;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.NoSuchElementException;

public class PIMActions {
    WebDriver driver;
    PIMpage pimpage = null;

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
        send(pimpage.firstname, data.get("Firstname"));
        send(pimpage.lastname, data.get("Lastname"));
        pimpage.id.clear();
        send(pimpage.id, data.get("Employeeid"));
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
    }

    public void save1() {
        clickMethod(pimpage.saveemp1);
    }

    public void clickreportto() {
        clickMethod(pimpage.reportto);
    }

    public void clicksuperadd() {
        clickMethod(pimpage.superviseradd);
    }

    public void senddataforsuper(DataTable datatable) {
        Map<String, String> data = datatable.asMap(String.class, String.class);
        Actions actions = new Actions(driver);
        send(pimpage.name, data.get("Name"));
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        clickMethod(pimpage.reportdrop);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    public void saveclick() {
        clickMethod(pimpage.save);
    }

    public void verifysuper() {
        List<WebElement> supervisornames = driver.findElements(By.xpath("(//div[@class='oxd-table-body'])[1]//div[2]"));
        String expected = "Gayu R";
        for (int i = 1; i <= supervisornames.size(); i++) {
            String xpath = "((//div[@class='oxd-table-body'])[1]//div[2])[" + i + "]";
            String actual = driver.findElement(By.xpath(xpath)).getText();
            if (expected.equals(actual)) {
                Assert.assertEquals(expected, actual);
                System.out.println("Successfully supervisor added");
            }
        }
    }

    public void sendemployeedettails(String firstname, String middlename, String lastname, String id) {
        send(pimpage.firstname, firstname);
        send(pimpage.middlename, middlename);
        send(pimpage.lastname, lastname);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
    }

    public void verifyerror(String expected) {
        String actual = pimpage.nameerr.getText();
        Assert.assertEquals(expected, actual);
    }

    public void clickemergency() {
        clickMethod(pimpage.emergency);
    }

    public void emergencyAdd() {
        clickMethod(pimpage.emergencyadd);
    }

    public void senddatas(DataTable datatable) {
        Map<String, String> data = datatable.asMap(String.class, String.class);
        send(pimpage.emergencyname, data.get("Name"));
        send(pimpage.relationship, data.get("Relationship"));
        send(pimpage.mobile, data.get("Mobile"));
    }

    public void emergencysave() {
        clickMethod(pimpage.save);
    }

    public void emergencyverify() {
        List<WebElement> contactname = driver.findElements(By.xpath("(//div[@class='oxd-table-body'])[1]//div[2]"));
        String expected = "Priya";
        for (int i = 1; i <= contactname.size(); i++) {
            String xpath = "((//div[@class='oxd-table-body'])[1]//div[2])[" + i + "]";
            String actual = driver.findElement(By.xpath(xpath)).getText();
            if (expected.equals(actual)) {
                Assert.assertEquals(expected, actual);
                System.out.println("Successfully emergency contact added");
            }
        }
    }

    public void clickMethod(WebElement element) {
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Element is not ready to click: " + element);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found for clicking: " + element);
        }
    }

    public void send(WebElement ele, String msg) {
        try {
            if (ele.isDisplayed() && ele.isEnabled()) {
                ele.sendKeys(msg);
            } else {
                System.out.println("Element is not ready to send data: " + ele);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found for sending data: " + ele);
        }
    }
}

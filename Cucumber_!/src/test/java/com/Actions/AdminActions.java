package com.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Pages.AdminPage;
import com.Utils.HelperClass;
import java.util.List;
import org.openqa.selenium.WebElement;

public class AdminActions {

    private WebDriver driver;
    private AdminPage adminPages;
    

    public AdminActions() {
        driver = HelperClass.getDriver();
        adminPages = new AdminPage();
        PageFactory.initElements(driver, adminPages);
    }

    public void goToAdminModule() {
        adminPages.adminTab.click();
    }

    public void goToEducationSection() {
        adminPages.qualificationsTab.click();
        adminPages.educationLink.click();
    }

    public void clickAddButton() {
        adminPages.addButton.click();
    }
    
    public void enterEducationLevel(String levelName) {
        if (levelName != null) {
            adminPages.educationNameInput.sendKeys(levelName);
        } 
    }

    public void clickSaveButton() {
        adminPages.saveButton.click();
    }
    
    public boolean isEducationDisplayed(String levelName) {
        List<WebElement> educationLevels = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='cell']"));

        for (WebElement level : educationLevels) {
            if (level.getText().equalsIgnoreCase(levelName)) {
                return true;
            }
        }
        return false;
    }
    
}


package com.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Pages.AdminPage;
import com.Utils.HelperClass;

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
        String xpath = "//div[@class='oxd-table-body']//div[text()='" + levelName + "']";
        return driver.findElement(By.xpath(xpath)).isDisplayed();
       
    }
    
    public boolean isDuplicateErrorDisplayed(String expectedError) {
        String xpath = "//span[text()='" + expectedError + "']";
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public boolean isDuplicateErrorDisplayed() {
        return adminPages.duplicateError.isDisplayed();
    }
    public void goToMembershipsSection() {
        adminPages.qualificationsTab.click();
        adminPages.membershipsLink.click();
    }


    public void enterMembershipName(String membershipName) {
        if (membershipName != null) {
            adminPages.membershipNameInput.sendKeys(membershipName);
        }
        
    }
    public boolean isMembershipDisplayed(String membershipName) {
        String xpath = "//div[@class='oxd-table-body']//div[text()='" + membershipName + "']";
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }  
}


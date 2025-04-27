package com.Actions;

import org.openqa.selenium.support.PageFactory;
import com.Pages.AdminPage2;
import com.Utils.HelperClass;

public class AdminActions2 {

    AdminPage2 adminpages = null;

    public AdminActions2() {
        adminpages = new AdminPage2();
        PageFactory.initElements(HelperClass.getDriver(), adminpages);
    }

    public void navigateToAdminModule() {
        adminpages.adminModule.click();
    }

    public void clickNationalities() {
        adminpages.nationalitiesOption.click();
    }

    public void clickAddButton() {
        adminpages.addButton.click();
    }

    public void enterNationalityName(String nationality) {
        adminpages.nameInput.sendKeys(nationality);
    }

    public void clickSaveButton() {
        adminpages.saveButton.click();
    }
    
    
    
    
    
    public String getActualRecordsFoundText() {
        return adminpages.getRecordsFoundText();
    }
}

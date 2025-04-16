package com.Actions;

import com.Pages.ClaimPage;
import com.Utils.HelperClass;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ClaimActions {
    ClaimPage cp;

    public ClaimActions() {
        cp = new ClaimPage();
        PageFactory.initElements(HelperClass.getDriver(), cp);
    }

    public void clickClaimModule() {
        cp.claimModule.click();
    }

    public void clickSubmitClaim() {
        cp.submitClaimTab.click();
    }

    public void selectEvent() {
        cp.eventDropdown.click();
        cp.selectEvent.click();  // Adjust with correct locator if needed
    }

    public void selectCurrency() {
        cp.currencyDropdown.click();
        cp.selectCurrency.click(); // Adjust with correct locator if needed
    }

    public void enterRemarks(String text) {
        cp.remarks.sendKeys(text);
    }

    public void clickCreate() {
        cp.createButton.click();
    }

    public boolean isClaimCreated() {
        return cp.successMsg.isDisplayed();  // Update locator if needed
    }

    public void clickAssignClaim() {
        cp.assignClaimTab.click();
    }

    public void assignClaim() {
        cp.selectEmployee.click();
        cp.selectEventAssignment.click();
        cp.selectExpense.click();
        cp.assignCreate.click();
    }

    public boolean isExpenseVisible() {
        return cp.expenseVisible.isDisplayed();  // Adjust locator
    }
}
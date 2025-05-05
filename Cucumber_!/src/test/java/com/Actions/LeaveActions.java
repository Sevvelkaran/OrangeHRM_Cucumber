package com.Actions;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.Pages.LeavePage;
import com.Utils.HelperClass;

public class LeaveActions {

    LeavePage lp;

    public LeaveActions() {
        lp = new LeavePage();
        PageFactory.initElements(HelperClass.getDriver(), lp);
    }

    public void navigateToLeaveModule() {
        lp.leaveMenu.click();
    }

    public void openAssignLeave() {
        lp.assignLeaveMenu.click();
    }

    public void fillLeaveDetails(String empName, String leaveType, String fromDate, String toDate) {
        lp.employeeNameInput.sendKeys(empName);
        
        lp.leaveTypeDropdown.click();
        boolean leaveTypeIs=true ;
        while (leaveTypeIs){
        	 String leave=lp.leaveTypeText.getText();
        	 System.out.println(leave);
             if(leave.contains(leaveType)) {
//            	 lp.leaveTypeText.sendKeys(Keys.ENTER,Keys.ENTER);
            	 leaveTypeIs=false ;
            	break;
             }
             lp.leaveTypeText.sendKeys(Keys.DOWN);
             
     
        }
       

        lp.fromDateInput.clear();
        lp.fromDateInput.sendKeys(fromDate);

        lp.toDateInput.clear();
        lp.toDateInput.sendKeys(toDate);
    }

    public void clickAssign() {
        lp.assignButton.click();
    }
}

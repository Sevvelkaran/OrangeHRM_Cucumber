package com.Actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.Pages.LoginPages;
import com.Utils.HelperClass;

public class LoginActions {

    LoginPages loginpages = null;

    public LoginActions() {
        loginpages = new LoginPages();
        PageFactory.initElements(HelperClass.getDriver(), loginpages);
    }

    public void enterUsernameAndPassword(String username, String password) {
        loginpages.Username.clear();
        loginpages.Password.clear();
        loginpages.Username.sendKeys(username);
        loginpages.Password.sendKeys(password);
    }

    public void Login() {
        loginpages.Loginbtn.click();
    }

    public void logout() {
        loginpages.Logout.click();
    }

    public void forgot() {
        loginpages.Forgot.click();
    }

    public void dro() {
        loginpages.Drop.click();
    }

}

package com.Actions;


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
        loginpages.username.clear();
        loginpages.password.clear();
        loginpages.username.sendKeys(username);
        loginpages.password.sendKeys(password);
    }

    public void Login() {
        loginpages.loginbtn.click();
    }

    public void logout() {
        loginpages.logout.click();
    }

    public void forgot() {
        loginpages.forgot.click();
    }

    public void dro() {
        loginpages.drop.click();
    }

}

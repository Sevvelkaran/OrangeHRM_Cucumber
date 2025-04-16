package com.Actions;

import com.Pages.LoginPage;
import com.Utils.HelperClass;
import org.openqa.selenium.support.PageFactory;

public class CommonActions {
    LoginPage login;

    public CommonActions() {
        login = new LoginPage();
        PageFactory.initElements(HelperClass.getDriver(), login);
    }

    public void login(String user, String pass) {
        login.username.sendKeys(user);
        login.password.sendKeys(pass);
        login.loginBtn.click();
    }
}

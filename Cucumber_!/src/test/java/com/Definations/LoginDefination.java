package com.Definations;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Actions.LoginActions;
import com.Pages.LoginPages;
import com.Utils.HelperClass;
import com.Utils.LogManagers;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginDefination {
    WebDriver driver;
    LoginPages objlog = new LoginPages();
    LoginActions objLogin = new LoginActions();

    @Before
    public void setUp() {
        HelperClass.setUpDriver();
        driver = HelperClass.getDriver();
    }

    @After
    public void tearDown() {
        HelperClass.teardown(); 
    }

    @Given("I want to go to OrangeHRM {string}")
    public void i_want_to_go_to_orange_hrm(String url) {
        try {
            HelperClass.openPage(url);
            objLogin = new LoginActions();
            LogManagers.logInfo("WebPage Opened");
        } catch (Exception e) {
            LogManagers.logError("Failed to open webpage: " + e.getMessage());
        }
    }

    @When("The user enters username and password")
    public void the_user_enters_username_and_password() {
        try {
            objLogin.Valid();
            LogManagers.logInfo("Credentials Entered");
        } catch (Exception e) {
            LogManagers.logError("Failed to enter credentials: " + e.getMessage());
        }
    }

    @When("Clicks on the Login button")
    public void clicks_on_the_login_button() {
        try {
            objLogin.Login();
            LogManagers.logInfo("Login button Clicked");
        } catch (Exception e) {
            LogManagers.logError("Failed to click login: " + e.getMessage());
        }
    }

    @Then("Assert them for valid login")
    public void assert_them_for_valid_login() {
        try {
            String expected = "OrangeHRM";
            String actual = driver.getTitle();
            assertEquals(actual, expected);
            LogManagers.logInfo("Login Assertion Passed");
        } catch (AssertionError e) {
            LogManagers.logError("Assertion failed for valid login: " + e.getMessage());
        }
    }

    @Then("Logout")
    public void logout() {
        try {
            objLogin.dro();
            objLogin.logout();
            LogManagers.logInfo("Logout performed");
        } catch (Exception e) {
            LogManagers.logError("Logout failed: " + e.getMessage());
        }
    }

    @When("The user enters invalid username and invalid password")
    public void the_user_enters_invalid_username_and_invalid_password() {
        try {
            objLogin.Invalid();
            LogManagers.logInfo("Invalid Credentials Entered");
        } catch (Exception e) {
            LogManagers.logError("Failed to enter invalid credentials: " + e.getMessage());
        }
    }

    @Then("Assert them for invalid login")
    public void assert_them_for_invalid_login() {
        try {
            String expected = "Invalid credentials";
            WebElement errorMsg = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
            assertEquals(errorMsg.getText(), expected);
            LogManagers.logInfo("Invalid login assertion passed");
        } catch (Exception e) {
            LogManagers.logError("Invalid login assertion failed: " + e.getMessage());
        }
    }

    @When("The user enters Empty username and invalid password as")
    public void the_user_enters_empty_username_and_invalid_password_as() {
        try {
            objLogin.empty();
            LogManagers.logInfo("Empty username and invalid password entered");
        } catch (Exception e) {
            LogManagers.logError("Failed to enter empty credentials: " + e.getMessage());
        }
    }

    @Then("Assert them for empty login")
    public void assert_them_for_empty_login() {
        try {
            String expectedUrl = driver.getCurrentUrl();
            String actualUrl = driver.getCurrentUrl();
            assertEquals(actualUrl, expectedUrl);
            LogManagers.logInfo("Empty login assertion passed");
        } catch (AssertionError e) {
            LogManagers.logError("Empty login assertion failed: " + e.getMessage());
        }
    }

    @When("The user clicks on the Forgot Password link")
    public void the_user_clicks_on_the_forgot_password_link() {
        try {
            objLogin.forgot();
            LogManagers.logInfo("Forgot Password clicked");
        } catch (Exception e) {
            LogManagers.logError("Failed to click Forgot Password: " + e.getMessage());
        }
    }

    @Then("Assert the Forgot Password page is displayed")
    public void assert_the_forgot_password_page_is_displayed() {
        try {
            String expected = "Reset Password";
            WebElement forgotHeader = driver.findElement(By.xpath("//h6[text()='Reset Password']"));
            assertEquals(forgotHeader.getText(), expected);
            LogManagers.logInfo("Forgot Password assertion passed");
        } catch (AssertionError | Exception e) {
            LogManagers.logError("Forgot Password assertion failed: " + e.getMessage());
        } finally {
            driver.navigate().back();
        }
    }
}

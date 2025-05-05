package com.Definations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @When("The user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        try {
            objLogin.enterUsernameAndPassword(username, password);
            LogManagers.logInfo("Entered credentials: " + username + "/" + password);
        } catch (Exception e) {
            LogManagers.logError("Failed to enter credentials: " + e.getMessage());
        }
    }

    @When("Clicks on the Login button")
    public void clicks_on_the_login_button() {
        try {
            objLogin.Login();
            LogManagers.logInfo("Login button clicked");
        } catch (Exception e) {
            LogManagers.logError("Login button click failed: " + e.getMessage());
        }
    }

    @Then("Assert them for valid login")
    public void assert_them_for_valid_login() {
        try {
            String expectedTitle = "OrangeHRM";
            String actualTitle = HelperClass.getDriver().getTitle();
            assertEquals(actualTitle, expectedTitle, "Login failed: Page title mismatch");
            LogManagers.logInfo("Valid login assertion passed");
        } catch (AssertionError e) {
            LogManagers.logError("Valid login assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Then("Assert them for invalid login")
    public void assert_them_for_invalid_login() {
        try {
            WebElement errorMsg = HelperClass.getDriver().findElement(By.xpath("//p[text()='Invalid credentials']"));
            assertTrue(errorMsg.isDisplayed(), "Error message not visible");
            assertEquals(errorMsg.getText(), "Invalid credentials", "Error message text mismatch");
            LogManagers.logInfo("Invalid login assertion passed");
        } catch (AssertionError | Exception e) {
            LogManagers.logError("Invalid login assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Then("Assert them for empty login")
    public void assert_them_for_empty_login() {
        try {
            WebElement usernameField = HelperClass.getDriver().findElement(By.name("username"));
            assertTrue(usernameField.isDisplayed(), "Expected to remain on login page");
            LogManagers.logInfo("Empty login assertion passed");
        } catch (AssertionError | Exception e) {
            LogManagers.logError("Empty login assertion failed: " + e.getMessage());
            throw e;
        }
    }


    @Then("Logout")
    public void logout() {
        try {
            objLogin.dro();
            objLogin.logout();
            LogManagers.logInfo("User logged out successfully");
        } catch (Exception e) {
            LogManagers.logError("Logout failed: " + e.getMessage());
        }
    }

    @When("The user clicks on the Forgot Password link")
    public void the_user_clicks_on_the_forgot_password_link() {
        try {
            objLogin.forgot();
            LogManagers.logInfo("Forgot Password link clicked");
        } catch (Exception e) {
            LogManagers.logError("Failed to click Forgot Password: " + e.getMessage());
        }
    }

    @Then("Assert the Forgot Password page is displayed")
    public void assert_the_forgot_password_page_is_displayed() {
        try {
            WebElement forgotHeader = driver.findElement(By.xpath("//h6[text()='Reset Password']"));
            assertEquals(forgotHeader.getText(), "Reset Password", "Forgot password page not displayed");
            LogManagers.logInfo("Forgot Password assertion passed");
        } catch (Exception e) {
            LogManagers.logError("Forgot Password assertion failed: " + e.getMessage());
        } finally {
            driver.navigate().back();
        }
    }
}

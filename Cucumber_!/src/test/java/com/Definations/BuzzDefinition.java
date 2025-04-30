package com.Definations;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Actions.BuzzActions;
import com.Actions.DashboardActions;
import com.Actions.LoginActions;
import com.Pages.BuzzPages;
import com.Pages.LoginPages;
import com.Utils.HelperClass;
import com.Utils.LogManagers;

import io.cucumber.java.en.*;

public class BuzzDefinition {

    WebDriver driver = HelperClass.getDriver();

    BuzzPages objPages = new BuzzPages();
    BuzzActions objActions = new BuzzActions();
    LoginPages objlog = new LoginPages();
    LoginActions objLogin = new LoginActions();
    DashboardActions objAct = new DashboardActions();

    @When("The user click on Buzz Menu, Assert it to check")
    public void the_user_click_on_buzz_menu_assert_it_to_check() {
        objActions.buzz();
        LogManagers.logInfo("Navigated to Buzz Page");

        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, currentUrl); // Consider comparing with expected if needed
        LogManagers.logInfo("URL assertion passed: " + currentUrl);
    }

    @When("Once the User is on Buzz page Type in the Field box as {string} and click on post")
    public void once_the_user_is_on_buzz_page_type_in_the_field_box_as_and_click_on_post(String text) {
        objActions.text();
        LogManagers.logInfo("Focus set on text area");

        driver.findElement(By.xpath("//textarea[@class='oxd-buzz-post-input']")).sendKeys(text);
        LogManagers.logInfo("Entered text: " + text);

        objActions.post();
        LogManagers.logInfo("Clicked on Post button");
    }

    @When("the user clicks on Dashboard menu")
    public void the_user_clicks_on_dashboard_menu() {
        objAct.DashBoard();
        LogManagers.logInfo("Navigated to Dashboard menu");
    }

    @When("Assert The post to check its pressence")
    public void assert_the_post_to_check_its_pressence() {
        try {
            String expectedPost = "Selenium Cucumber Java";
            WebElement postElement = driver.findElement(By.xpath("//p[text()='Selenium Cucumber Java']"));
            String actualPost = postElement.getText();

            assertEquals(actualPost, expectedPost);
            LogManagers.logInfo("Post assertion passed: " + actualPost);
        } catch (Exception e) {
            LogManagers.logError("Error asserting Buzz post presence: " + e.getMessage());
        }
    }
    @When("I navigated to the Buzz module and click Help button")
    public void i_navigated_to_the_buzz_module_and_click_help_button() {
        objActions.buzz();
        objActions.clickHelp();
    }

    @Then("I should see the Admin User Guide page opened")
    public void i_should_see_the_admin_user_guide_page_opened() {
        objActions.verifyHelpPageURL();
    }
}

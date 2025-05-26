package com.Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClaimAction {

    WebDriver driver;
    WebDriverWait wait;

    public ClaimAction(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();
    }

    public void navigateToClaimAndSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Claim']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Submit Claim']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Event')]/following::div[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Travel Allowance']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Currency')]/following::div[1]"))).click();
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='United States Dollar']"))).click();
       
    }

    public void verifyClaimSuccess() {
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Successfully Saved')]")));
        if (!successMsg.isDisplayed()) {
            throw new AssertionError("Claim was not submitted successfully.");
        }
    }
}

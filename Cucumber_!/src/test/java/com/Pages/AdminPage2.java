package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage2 {

    @FindBy(xpath = "(//*[@class=\"oxd-icon oxd-main-menu-item--icon\"]//following-sibling::span)[1]")
    public WebElement adminModule;

    @FindBy(xpath = "(//li[@class=\"oxd-topbar-body-nav-tab --parent\"]//following-sibling::li)[3]")
    public WebElement nationalitiesOption;

    @FindBy(xpath = "//div[@class=\"orangehrm-header-container\"]//child::button")
    public WebElement addButton;

    @FindBy(xpath = "//label[text()='Name']/following::input[1]")
    public WebElement nameInput;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--ghost\"]//following-sibling::button")
    public WebElement saveButton;

    @FindBy(xpath = "//span[text()='Required']")
    public WebElement requiredMessage;

}


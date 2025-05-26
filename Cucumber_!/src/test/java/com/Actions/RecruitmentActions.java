package com.Actions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Pages.RecruitmentPages;
import com.Utils.HelperClass;

import java.time.Duration;

public class RecruitmentActions {

    RecruitmentPages objPages = null;
    WebDriverWait wait;

    public RecruitmentActions() {
        objPages = new RecruitmentPages();
        PageFactory.initElements(HelperClass.getDriver(), objPages);
        wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
    }

    public void UsernameAndPassword(String username, String password) {
        objPages.Username.clear();
        objPages.Password.clear();
        objPages.Username.sendKeys(username);
        objPages.Password.sendKeys(password);
    }

    public void clickLogin() {
        objPages.Loginbtn.click();
    }

    public void openRecruitmentAndCandidatesPage() {
        objPages.recruitmentTab.click();
        objPages.candidatesPage.click();
    }

    public void clickAddButton() {
        objPages.addButton.click();
    }

    public void enterCandidateName(String firstName, String middleName, String lastName) {
        objPages.firstName.clear();
        objPages.firstName.sendKeys(firstName);
        objPages.middleName.clear();
        objPages.middleName.sendKeys(middleName);
        objPages.lastName.clear();
        objPages.lastName.sendKeys(lastName);
    }

    public void selectFirstVacancyOption() {
        objPages.vacancyDropdown.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(objPages.dropdownOptions));
        List<WebElement> options = objPages.dropdownOptions;
        if (options != null && options.size() > 2) {
            options.get(2).click();
        } else {
            throw new RuntimeException("Not enough options found in the Vacancy dropdown");
        }
    }

    public void enterEmailAndContact(String email, String contact) {
        wait.until(ExpectedConditions.visibilityOf(objPages.email));
        objPages.email.clear();
        objPages.email.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(objPages.contactNumber));
        objPages.contactNumber.clear();
        objPages.contactNumber.sendKeys(contact);
    }

    public void enterKeywords(String keyword) {
        objPages.keywords.clear();
        objPages.keywords.sendKeys(keyword);
    }

    public void clickSave() {
        objPages.saveButton.click();
    }

    public String getCandidateNameText() {
        return objPages.candidateName.getText();
    }
}

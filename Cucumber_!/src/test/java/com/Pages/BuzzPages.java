package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuzzPages {
	
	
	@FindBy(xpath = "(//a[@class=\"oxd-main-menu-item\"]//child::span)[11]")
	public WebElement buzz;
	
	@FindBy(xpath="//div[@class=\"oxd-buzz-post oxd-buzz-post--active\"]//child::textarea")
	public WebElement textArea;
	
	@FindBy(xpath = "//div[@class=\"oxd-buzz-post-slot\"]//child::button")
	public WebElement post;
	
	@FindBy(xpath = "//*[@id=\"heart-svg\"]")
	public WebElement heart;
	
	@FindBy(xpath = "(//p[@class=\"oxd-text oxd-text--p orangehrm-buzz-post-body-readmore\"]//preceding-sibling::p)[1]")
	public WebElement home;
	
    @FindBy(xpath = "(//button[@class=\"oxd-icon-button\"]//child::i)[1]")
    public WebElement helpButton;

    @FindBy(xpath = "//a[text()='Admin Guide']")
    public WebElement adminGuideLink;

    @FindBy(xpath = "//div[@class=\"category-content\"]//child::header")
    public WebElement adminUserGuideHeader;

    @FindBy(xpath = "//p[@class=\"oxd-text oxd-text--p orangehrm-buzz-anniversary-job-details\"]")
    public WebElement upcomingAnniversaries;
}
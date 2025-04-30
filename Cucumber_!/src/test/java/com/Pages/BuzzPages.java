package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuzzPages {
	
	
	@FindBy(xpath = "//span[text()='Buzz']")
	public WebElement Buzz;
	
	@FindBy(xpath="//textarea[@placeholder=\"What's on your mind?\"]")
	public WebElement TextArea;
	
	@FindBy(xpath = "//button[text()=' Post ']")
	public WebElement Post;
	
	@FindBy(xpath = "//*[@id=\"heart-svg\"]")
	public WebElement Heart;
	
	@FindBy(xpath = "//p[text()='Selenium Cucumber Java']")
	public WebElement Home;
	
    @FindBy(xpath = "//i[@class='oxd-icon bi-question-lg']")
    public WebElement HelpButton;

    @FindBy(xpath = "//a[text()='Admin Guide']")
    public WebElement AdminGuideLink;

    @FindBy(xpath = "//header[@class='page-header']")
    public WebElement AdminUserGuideHeader;


}
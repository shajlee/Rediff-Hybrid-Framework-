package com.qa.practicerediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInLinkTestPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInLink;
	
	@FindBy(css = "div.logtext")
	private WebElement rediffMailLogo;
	
	public SignInLinkTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignInLink() {
		 signInLink.click();
	}
	public boolean rediffMailLogoIsDisplayed() {
		boolean displayStatus = rediffMailLogo.isDisplayed();
		return displayStatus;
		
		
		
		
	}

}

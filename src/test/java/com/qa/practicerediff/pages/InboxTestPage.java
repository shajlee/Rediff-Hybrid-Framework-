package com.qa.practicerediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxTestPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInLink;
	
	@FindBy(id = "login1")
	private WebElement userNameTextBox;
	
	@FindBy(id = "password")
	private WebElement passwordTextBox;
	
	@FindBy(className = "signinbtn")
	private WebElement signInButton;
	
	@FindBy(className = "rd_active")
	private WebElement inboxButton;
	
	public InboxTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignInLink() {
		signInLink.click();
	}
	public void enterUserName(String usernameText) {
		userNameTextBox.sendKeys(usernameText);
	}
	public void enterPassword(CharSequence passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void clickOnSignInButton() {
		signInButton.click();
	}
	public boolean inboxButtonIsDisplayedAndEnable() {
		boolean displaystatus = inboxButton.isDisplayed() && inboxButton.isEnabled() ;
		return displaystatus;
	}

}

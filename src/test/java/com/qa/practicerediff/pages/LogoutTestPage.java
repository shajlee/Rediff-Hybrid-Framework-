package com.qa.practicerediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutTestPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInLink;
	
	@FindBy(id = "login1")
	private WebElement usernameTextBox;
	
	@FindBy(id = "password")
	private WebElement passwordTextBox;
	
	@FindBy(className = "signinbtn")
	private WebElement signInButton;
	
	@FindBy(className = "rd_logout")
	private WebElement logOutButton;
	
	@FindBy(css = "div.panel p")
	private WebElement signOutMessage;
	
	public LogoutTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignInLink() {
		 signInLink.click();
	}
	public void enterUserName(String usernameText) {
		usernameTextBox.sendKeys(usernameText);
	}
	public void enterPassword(CharSequence passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void clickOnSignInButton() {
		signInButton.click();
	}
	public WebElement logOutButton() {
		return logOutButton;
	}
	public boolean signOutMessageIsDisplayed() {
		boolean signOutMsg = signOutMessage.isDisplayed();
		return signOutMsg;
	}

}

package com.qa.practicerediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTestsPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInLink;
	
	@FindBy(id = "login1")
	private WebElement usernameTextBox;
	
	@FindBy(id = "password")
	private WebElement passwordTextBox;
	
	@FindBy(className = "signinbtn")
	private WebElement signInButton;
	
	@FindBy(css = "a.rd_setting_panel")
	private WebElement settingsButton;
	
	@FindBy(css = "div#div_login_error")
	private WebElement invalidCredentialsErrorMessage;
	
	@FindBy(css = "div#div_login_error")
	private WebElement invalidPasswordErrorMessage;
	
	@FindBy(css = "div#div_login_error")
	private WebElement invalidUsernameErrorMessage;
	
	public LoginTestsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnsignInLink() {
		signInLink.click();
	}
	public void Enterusername(String usernameText) {
		usernameTextBox.sendKeys(usernameText);
	}
	public void EnterPassword(CharSequence passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void clockOnSignInButton() {
		signInButton.click();
	}
	public boolean settingsButtonIsDisplayedAndEnabled() {
		boolean displaystatus = settingsButton.isDisplayed() && settingsButton.isEnabled();
		return displaystatus;
	}
	public boolean invalidCredentialsErrorMessageIsDisplayed() {
		boolean invalidCredMsg = invalidCredentialsErrorMessage.isDisplayed();
		return invalidCredMsg;
	}
	public boolean invalidPasswordErrorMessageIsDisplayed() {
		boolean invalidPassWorsMsg = invalidPasswordErrorMessage.isDisplayed();
		return invalidPassWorsMsg;
	}
	public boolean invalidUsernameErrorMessageIsDisplayed() {
		boolean invalidUsernameMsg = invalidUsernameErrorMessage.isDisplayed();
		return invalidUsernameMsg;
	
		
		
		
		

		
	}
	

}

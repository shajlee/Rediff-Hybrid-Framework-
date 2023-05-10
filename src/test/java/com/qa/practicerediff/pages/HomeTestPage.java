package com.qa.practicerediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeTestPage {
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
	
	@FindBy(css = "div.header div a img")
	private WebElement rediffHomeButton;
	
	@FindBy(css = "span.hmsprite.logo")
	private WebElement rediffLogo;
	
	public HomeTestPage(WebDriver driver) {
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
	public void clicOnRediffHome() {
		rediffHomeButton.click();
	}
	public boolean rediffLogoIsDisplayed() {
		boolean logo = rediffLogo.isDisplayed();
		return logo;
		
	}
	
	
	

}
